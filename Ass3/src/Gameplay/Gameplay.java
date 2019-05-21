package Gameplay;

import Units.ActiveGameUnit;
import Units.Enemy;
import Units.Monster;
import Units.Player;
import Utils.PlayerChooser;
import IO.StringSubject;

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
        possibleCharacters = PlayerChooser.getPlayer();
        levelidx = 0;
        maxLevel = levels.size();
    }

    public void startGame(int playerId) {
        currentLevel = levels.get(levelidx);
        board = currentLevel.getBoard();
        enemies = currentLevel.getEnemies();
        this.player = possibleCharacters.get(playerId);
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
     * @param wall
     * @param unit
     */
    void unitToWall(Wall wall, ActiveGameUnit unit) {
        //TODO: do we need to do something?
    }

    /**
     * @param attacker
     * @param defender
     */
    public void handleCombat(ActiveGameUnit attacker, ActiveGameUnit defender, int attack) {
        StringSubject.getInstance().notifyObservers(attacker.getName() + " engaged in battle with " + defender.getName() + ":");
        StringSubject.getInstance().notifyObservers(attacker.toString());
        StringSubject.getInstance().notifyObservers(defender.toString());
        //int attack = attacker.attack();
        StringSubject.getInstance().notifyObservers(attacker.getName() + " rolled " + attack + " attack points");
        int damage = defender.defend(attack);
        StringSubject.getInstance().notifyObservers(attacker.getName() + " hit " + defender.getName() + " for " + damage + " points");
        defender.checkIfDead(this,attacker);
            //TODO: manage death
            //enemies.remove(defender);
            //board[defender.getPosition().getX()][defender.getPosition().getY()] = new EmptySpot('.', defender.getPosition());

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
        LinkedList<Tile> emptyTiles = new LinkedList<>();//perhaps nulls?
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

    public List<Tile> enemiesInRange(Position position, int radius) {
        LinkedList<Tile> monsters = new LinkedList<>();
        for (int x = position.getX() - radius < 0 ? 0 : position.getX() - radius;
             x < board.length && x < position.getX() + radius; x++) {
            for (int y = position.getY() - radius < 0 ? 0 : position.getY() - radius;
                 y < board[0].length && y < position.getY() + radius; y++) {
                if (!board[x][y].isMovable()) {
                    monsters.add(board[x][y]);
                }
            }
        }
        return monsters;
    }

    public void handlePlayerKilledEnemy(ActiveGameUnit attacker, Enemy enemy, int exp) {
        attacker.addExperience(exp);
    }
}