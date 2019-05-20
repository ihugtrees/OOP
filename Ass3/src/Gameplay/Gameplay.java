package Gameplay;

import Units.ActiveGameUnit;
import Units.Enemy;
import Units.Player;

import java.util.LinkedList;
import java.util.List;

public class Gameplay {

    private Player player;
    private LinkedList<Enemy> enemies;
    private Board board;

    /**
     * @param playerMove
     */
    public void turn(char playerMove) throws Exception {
        Position playerPosition = player.getPosition();

        Tile moveTo;
        switch (playerMove) {
            case 'w':
                playerMove( playerPosition.getX(), playerPosition.getY() + 1);
                break;
            case 's':
                playerMove(playerPosition.getX(), playerPosition.getY() - 1);
                break;
            case 'a':
                playerMove( playerPosition.getX() - 1, playerPosition.getY());
                break;
            case 'd':
                playerMove( playerPosition.getX() + 1, playerPosition.getY());
                break;
            case 'e':
                playerAbility();
                break;
            case 'q':
                continueEnemyTurn();
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
    public void playerMove( int x, int y) {
        Tile t = board.getTileAt(x, y);
        t.unitApproach(this, player);
    }

    public void playerAbility() {
        player.playerAbility(this);
    }

    /**
     * @param empty
     * @param unit
     */
    public void unitToEmpty(EmptySpot empty, ActiveGameUnit unit) {
        Position tmp = empty.getPosition();
        empty.setPosition(unit.getPosition());
        unit.setPosition(tmp);
    }

    /**
     * @param wall
     * @param unit
     */
    public void unitToWall(Wall wall, ActiveGameUnit unit) {
        //TODO: do we need to do something?
    }

    /**
     * @param attacker
     * @param defender
     */
    public void handleCombat(ActiveGameUnit attacker, ActiveGameUnit defender) {

        int attack = attacker.attack();
        int life = defender.defend(attack);
        if (life <= 0) {
            //TODO: manage death
        }
    }

    /**
     * @param radius
     * @param position
     */
    public List<Tile> getEmptyTileInRadius(int radius, Position position) {
        return board.getEmptyTileInRadius(radius, position);
    }

    /**
     * @param x
     * @param y
     */
    public void monsterMove(ActiveGameUnit monster, int x, int y) {
        Tile moveTo = board.getTileAt(x, y);
        moveTo.unitApproach(this, monster);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}