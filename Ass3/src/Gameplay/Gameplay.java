package Gameplay;

import Units.ActiveGameUnit;
import Units.Enemy;
import Units.Player;
import PlayerChooser;
import IO.StringSubject;
import Utils.Util;

import java.util.LinkedList;
import java.util.List;

public class Gameplay {
    private List<Player> possibleCharacters;
    private Player player;
    private List<Enemy> enemies;
    private Tile[][] board;
    private List<Level> levels;
    private Level currentLevel;
    private int levelidx;
    private int maxLevel;
    private boolean isOver;

    public List<String> getAllCharacters() {
        List<String> playersToString = new LinkedList<>();
        for (Player p : possibleCharacters) {
            playersToString.add(p.toString());
        }
        return playersToString;
    }

    public Gameplay(List<Level> levels) {
        isOver = false;
        this.levels = levels;
        possibleCharacters = HeroGenerator.getHeroes();
        levelidx = 0;
        maxLevel = levels.size();
    }

    public void startGame(int playerId) {
        player = possibleCharacters.get(playerId);
        loadLevel();
    }

    private void loadLevel() {
        currentLevel = levels.get(levelidx);
        board = currentLevel.getBoard();
        enemies = currentLevel.getEnemies();

        player.setPosition(currentLevel.getPlayerPosition());
        if (board[player.getPosition().getX()][player.getPosition().getY()] == null) {
            board[player.getPosition().getX()][player.getPosition().getY()] = player;
        } else {
            StringSubject.getInstance().notifyObservers("Something went wrong, player position is already taken");
        }

    }

    /**
     * @param playerMove
     */

    public void turn(char playerMove) throws Exception {
        Position playerPosition = player.getPosition();
        player.turn();

        switch (playerMove) {
            case 'w':
                playerMove(playerPosition.getX(), playerPosition.getY() - 1);
                break;
            case 's':
                playerMove(playerPosition.getX(), playerPosition.getY() + 1);
                break;
            case 'a':
                playerMove(playerPosition.getX() - 1, playerPosition.getY());
                break;
            case 'd':
                playerMove(playerPosition.getX() + 1, playerPosition.getY());
                break;
            case 'e':
                playerAbility();
                break;
            case 'q':
                break;
            default:
                throw new Exception("wrong input");
        }
        continueEnemyTurn();
    }

    private void continueEnemyTurn() {
        for (Enemy enemy : enemies) {
            enemy.turn(player.getPosition(), this);
        }
    }

    /**
     * @param
     * @param x
     * @param y
     */
    private void playerMove(int x, int y) {
        Tile t = board[x][y];
        t.unitApproach(this, player);
    }

    private void playerAbility() {
        player.playerAbility(this);
    }

    /**
     * @param empty
     * @param unit
     */
    void unitToEmpty(EmptySpot empty, ActiveGameUnit unit) {
        Position tmp = empty.getPosition();
        empty.setPosition(unit.getPosition());
        unit.setPosition(tmp);
        board[empty.getPosition().getX()][empty.getPosition().getY()] = empty;
        board[unit.getPosition().getX()][unit.getPosition().getY()] = unit;
    }

    /**
     * @param x
     * @param y
     */
    public void monsterMove(ActiveGameUnit monster, int x, int y) {
        Tile moveTo = board[x][y];
        moveTo.unitApproach(this, monster);
    }


    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @param radius
     * @param position
     */
    public List<Tile> getEmptyTileInRadius(int radius, Position position) {
        LinkedList<Tile> emptyTiles = new LinkedList<>();
        for (int x = position.getX() - radius < 0 ? 0 : position.getX() - radius;
             x < board.length && x < position.getX() + radius; x++) {
            for (int y = position.getY() - radius < 0 ? 0 : position.getY() - radius;
                 y < board.length && y < position.getY() + radius; y++) {
                if (board[x][y].isMovable()) {
                    emptyTiles.add(board[x][y]);
                }
            }
        }
        return emptyTiles;
    }

    public String getPlayerStat() {
        return player.toString();
    }

    public boolean isOver() {
        return isOver;
    }

    public String boardToString() {
        String boardString = "";
        for (int y = 0; y < board[0].length; y++) {
            for (int x = 0; x < board.length; x++) {
                boardString += board[x][y].tileSign;
            }
            boardString += '\n';
        }
        return boardString;
    }

    public void playerDied() {
        isOver = true;
    }

    public List<Enemy> enemiesInRange(Position position, int radius) {
        LinkedList<Enemy> monsters = new LinkedList<>();
        for (Enemy e : enemies)
            if (Util.isInRange(e.getPosition(), position, radius))
                monsters.add(e);
        return monsters;
    }

    public void handlePlayerKilledEnemy(ActiveGameUnit attacker, Enemy enemy, int exp) {
        player.addExperience(exp);
        Position pos = enemy.getPosition();
        board[pos.getX()][pos.getY()] = new EmptySpot('.', pos);
        enemies.remove(enemy);
        if (enemies.isEmpty())
            nextLevel();
    }

    private void nextLevel() {
        levelidx++;
        if (levelidx < levels.size())
            loadLevel();
        else
            isOver = true;
    }
}