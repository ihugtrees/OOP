package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public final class RandomGeneratorImpl implements RandomGenerator {

    private static RandomGeneratorImpl generator;

    private Random rnd = new Random();
    private boolean isD;
    private File randomNumbers;
    private String nextDetMove;
    BufferedReader br;

    private RandomGeneratorImpl() {

    }

    public static RandomGeneratorImpl getInstance() {
        if (generator == null)
            generator = new RandomGeneratorImpl();
        return generator;
    }

    public void setDeterministic(boolean isD, File randomNumbers) {
        this.isD = isD;
        this.randomNumbers = randomNumbers;
        try {
            this.br = new BufferedReader(new FileReader(randomNumbers));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        nextDetMove = "";
    }

    public int nextInt(int n) {
        if (!isD)
            return rnd.nextInt(n);
        else {
            try {
                if ((nextDetMove = br.readLine()) != null) {
                    return Integer.parseInt(nextDetMove);
                }
                return -1;
            } catch (Exception e) {
                return -1;
            }
        }
    }
}