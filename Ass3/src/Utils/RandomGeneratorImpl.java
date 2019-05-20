package Utils;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {

    private Random rnd = new Random();
    private boolean isD;

    public RandomGeneratorImpl(boolean d){
        isD = d;
    }

    public int nextInt(int n) {
        if(isD)
            return rnd.nextInt(n);
        else
            return 0;
    }
}