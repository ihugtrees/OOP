package Gameplay;

import Units.Mage;
import Units.Monster;
import Units.Player;

import static org.junit.Assert.*;

public class GameplayTest {

    @org.junit.Test
    public void playerMove() {
        Gameplay gameplay = new Gameplay();
        Position position = new Position(0,0);
        Player p = new Mage('s',position,"name",100,100,51,21,0,
                1,5,25,25,1,1,1);
        Tile [][] board = new Tile[2][1];
        board[0][0]=p;
        board[1][0]=new Monster('w',new Position(1,0),"mon",
                2,1,1,1,1);
        Board b = new Board(board);
        gameplay.setBoard(b);
        gameplay.setPlayer(p);
        gameplay.playerMove(1,0);

    }
}