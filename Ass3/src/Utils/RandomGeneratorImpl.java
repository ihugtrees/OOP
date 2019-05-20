package Utils;



import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {

    private static Random rnd = new Random();
    private static boolean isD;

    public RandomGeneratorImpl(boolean d){
        isD = d;
    }
    private static RandomGenerator ourInstance = new RandomGeneratorImpl(false);

    public static RandomGenerator getInstance() {
        return ourInstance;
    }
    public int nextInt(int n) {
        if(!isD)
            return rnd.nextInt(n);
        else
            return 0;
    }
}