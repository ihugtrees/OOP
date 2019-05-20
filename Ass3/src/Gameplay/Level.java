package Gameplay;

import Units.Enemy;
import Units.Monster;
import Units.Trap;
import IO.StringSubject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Level {
    private Tile[][] board;
    private Position playerPosition;
    private List<Enemy> enemies;

    public Level(String path) {
        List<String> boardString = readAllLines(path);
        enemies = new LinkedList<>();

        board = new Tile[boardString.get(0).length()][boardString.size()];
        for (int y = 0; y < boardString.size(); y++) {
            for (int x = 0; x < boardString.get(0).length(); x++) {

                try {
                    board[x][y] = getTileFromChar(boardString.get(y).charAt(x), x, y);
                } catch (Exception e) {
                    StringSubject.getInstance().notifyObservers(e.getMessage());
                }
            }
        }
    }

    private Tile getTileFromChar(char c, int x, int y) throws Exception {
        switch (c) {
            case '.':
                return new EmptySpot('.', new Position(x, y));
            case '#':
                return new Wall('#', new Position(x, y));
            case '@':
                playerPosition = new Position(x, y);
                return null;
            case 's':
                return new Monster('s', new Position(x, y), "Lannister Solider", 80, 8, 3, 2, 25);
            case 'k':
                return new Monster('k', new Position(x, y), "Lannister Knight", 200, 15, 8, 4, 50);
            case 'q':
                return new Monster('q', new Position(x, y), "Queen's Guard", 400, 20, 15, 5, 100);
            case 'z':
                return new Monster('z', new Position(x, y), "Wright", 600, 30, 15, 3, 100);
            case 'b':
                return new Monster('b', new Position(x, y), "Bear-Wright", 1000, 75, 30, 4, 250);
            case 'g':
                return new Monster('g', new Position(x, y), "Giant-Wright", 1500, 100, 40, 5, 500);
            case 'w':
                return new Monster('w', new Position(x, y), "White Walker", 2000, 150, 50, 6, 1000);
            case 'M':
                return new Monster('M',new Position(x,y),"The Mountain",1000,60,25,6,500);
            case 'C':
                return new Monster('C',new Position(x,y),"Queen Cersei",100,10,10,1,1000);
            case 'K':
                return new Monster('K',new Position(x,y),"Night King",5000,300,150,8,5000);
            case 'B':
                return new Trap('B',new Position(x,y),"Bonus \"Trap\"",1,1,1,5,6,2,0,true,250);
            case 'Q':
                return new Trap('Q',new Position(x,y),"Queen's Trap",250,50,10,4,10,4,0,true,100);
            case 'D':
                return new Trap('D',new Position(x,y),"Death Trap",500,100,20,6,10,3,0,true,250);
                default:
                    throw new Exception("unknown monster in position ("+x+","+y+")");
        }
    }

    private List<String> readAllLines(String path) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String next;
            while ((next = reader.readLine()) != null) {
                lines.add(next);
            }
        } catch (FileNotFoundException e) { /* Handle FileNotFoundException*/ } catch (IOException e) {/* Handle IOException*/}
        return lines;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
    public Tile[][] getBoard(){
        return board;
    }
}