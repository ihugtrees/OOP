package Utils;

public class Util {
    public static boolean isInRange(int x1,int y1,int x2,int y2,int radius){
        return radius>Math.sqrt((x1-x2)^2+(y1-y2)^2);
    }
}
