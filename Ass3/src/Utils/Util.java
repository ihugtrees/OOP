package Utils;

import Gameplay.Position;

public class Util {
    public static boolean isInRange(Position p1, Position p2, int radius) {
        return radius >= Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
    }
}