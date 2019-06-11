package Utils;

import java.util.Random;

public final class RandomGeneratorImpl implements RandomGenerator {

    private static RandomGeneratorImpl generator;

    private Random rnd = new Random();
    private boolean isD;

    private RandomGeneratorImpl() {
    }

    public static RandomGeneratorImpl getInstance() {
        if (generator == null)
            generator = new RandomGeneratorImpl();
        return generator;
    }

    public void setDeterministic(boolean isD) {
        this.isD = isD;
    }

    public int nextInt(int n) {
        if (!isD)
            return rnd.nextInt(n);
        else
            return 0;
    }
}