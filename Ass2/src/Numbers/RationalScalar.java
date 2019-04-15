package Numbers;

public class RationalScalar implements Scalar {

    private int up;
    private int down;

    public static Scalar getReational(int up, int down) {
        if (down != 0) {
            int divider = largestDivider(up, down);
            return new RationalScalar(up / divider, down / divider);
        }
        System.out.println("Denominator can't be 0");
        return null;
    }

    private static int largestDivider(int up, int down) {
        up = Math.abs(up);
        down = Math.abs(down);

        while (up != down) {
            if (up > down)
                up = up - down;
            else
                down = down - up;
        }
        return down;
    }

    private RationalScalar(int up, int down) {
        this.up = up;
        this.down = down;
        checkIfDownNegative();
    }

    private void checkIfDownNegative() {
        if (down < 0) {
            up = -1 * up;
            down = -1 * down;
        }
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    @Override
    public Scalar add(Scalar s) {
        if (s instanceof RationalScalar) {
            int upByOtherDown = up * ((RationalScalar) s).getDown();
            int downByOtherUp = down * ((RationalScalar) s).getUp();
            int sumOfTop = upByOtherDown + downByOtherUp;
            int downByDown = down * ((RationalScalar) s).getDown();
            int divider = largestDivider(sumOfTop, downByDown);
            up = sumOfTop / divider;
            down = downByDown / divider;
            checkIfDownNegative();
            return this;
        }
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        if (s instanceof RationalScalar) {
            up = up * ((RationalScalar) s).getUp();
            down = down * ((RationalScalar) s).getDown();
            int divider = largestDivider(up, down);
            up = up / divider;
            down = down / divider;
            checkIfDownNegative();
            return this;
        }
        return null;
    }

    @Override
    public Scalar pow(int exponent) {
        if (exponent == 0) {
            up = 1;
            down = 1;
            return this;
        }

        for (int i = 0; i < exponent; i++) {
            up = up * up;
            down = down * down;
        }

        if (exponent > 0)
            return this;

        int temp = up;
        up = down;
        down = temp;
        checkIfDownNegative();

        return this;
    }

    @Override
    public Scalar neg() {
        up = -1 * up;
        checkIfDownNegative();
        return this;
    }

    @Override
    public boolean equals(Scalar s) {
        if (s instanceof RationalScalar) {
            return up == ((RationalScalar) s).getUp() && down == ((RationalScalar) s).getDown();
        }
        return false;
    }

    @Override
    public Scalar mulByInt(int num) {
        up = up * num;
        return this;
    }

    public String toString() {
        if (down == 1)
            return ""+up;

        return up + "/" + down;
    }
}