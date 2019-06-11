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
        Enemy e;
        switch (c) {

            case '.':
                return new EmptySpot('.', new Position(x, y));

            case '#':
                return new Wall('#', new Position(x, y));

            case '@':
                playerPosition = new Position(x, y);
                return null;

            case 's':
                e = new Monster('s', new Position(x, y), "Lannister Solider", 80, 8, 3, 3, 25);
                enemies.add(e);
                return e;

            case 'k':
                e = new Monster('k', new Position(x, y), "Lannister Knight", 200, 14, 8, 4, 50);
                enemies.add(e);
                return e;

            case 'q':
                e = new Monster('q', new Position(x, y), "Queen's Guard", 400, 20, 15, 5, 100);
                enemies.add(e);
                return e;

            case 'z':
                e = new Monster('z', new Position(x, y), "Wright", 600, 30, 15, 3, 100);
                enemies.add(e);
                return e;

            case 'b':
                e = new Monster('b', new Position(x, y), "Bear-Wright", 1000, 75, 30, 4, 250);
                enemies.add(e);
                return e;

            case 'g':
                e = new Monster('g', new Position(x, y), "Giant-Wright", 1500, 100, 40, 5, 500);
                enemies.add(e);
                return e;

            case 'w':
                e = new Monster('w', new Position(x, y), "White Walker", 2000, 150, 50, 6, 1000);
                enemies.add(e);
                return e;

            case 'M':
                e = new Monster('M', new Position(x, y), "The Mountain", 1000, 60, 25, 6, 500);
                enemies.add(e);
                return e;

            case 'C':
                e = new Monster('C', new Position(x, y), "Queen Cersei", 100, 10, 10, 1, 1000);
                enemies.add(e);
                return e;

            case 'K':
                e = new Monster('K', new Position(x, y), "Night King", 5000, 300, 150, 8, 5000);
                enemies.add(e);
                return e;

            case 'B':
                e = new Trap('B', new Position(x, y), "Bonus \"Trap\"", 1, 1, 1, 5, 6, 2, 0, true, 250);
                enemies.add(e);
                return e;

            case 'Q':
                e = new Trap('Q', new Position(x, y), "Queen's Trap", 250, 50, 10, 4, 10, 4, 0, true, 100);
                enemies.add(e);
                return e;

            case 'D':
                e = new Trap('D', new Position(x, y), "Death Trap", 500, 100, 20, 6, 10, 3, 0, true, 250);
                enemies.add(e);
                return e;

            default:
                throw new Exception("unknown monster in position (" + x + "," + y + ")");
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

    Position getPlayerPosition() {
        return playerPosition;
    }

    List<Enemy> getEnemies() {
        return enemies;
    }

    Tile[][] getBoard() {
        return board;
    }
}