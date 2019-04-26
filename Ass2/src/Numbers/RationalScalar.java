package Numbers;

public class RationalScalar implements Scalar {

    private int up;
    private int down;

    public static RationalScalar createRational(int up, int down) {
        if (down != 0) {
            return new RationalScalar(up, down);
        }
        System.out.println("Denominator can't be 0");
        return null;
    }

    private void reduceByDivider(int up, int down) {
        if (up != 0) {
            up = Math.abs(up);
            down = Math.abs(down);

            while (up != down) {
                if (up > down)
                    up = up - down;
                else
                    down = down - up;
            }
            this.up = this.up / down;
            this.down = this.down / down;
        }
    }

    private RationalScalar(int up, int down) {
        this.up = up;
        this.down = down;
        reduceByDivider(up, down);
        checkIfDownNegative();
    }

    private void checkIfDownNegative() {
        if (down < 0) {
            up = (-1) * up;
            down = (-1) * down;
        }
    }

    private int getUp() {
        return up;
    }

    private int getDown() {
        return down;
    }

    @Override
    public Scalar add(Scalar s) {
        int upByOtherDown = up * ((RationalScalar) s).getDown();
        int downByOtherUp = down * ((RationalScalar) s).getUp();
        int sumOfTop = upByOtherDown + downByOtherUp;
        int downByDown = down * ((RationalScalar) s).getDown();

        up = sumOfTop;
        down = downByDown;

        checkIfDownNegative();
        reduceByDivider(sumOfTop, downByDown);
        return this;
    }

    @Override
    public Scalar mul(Scalar s) {
        up = up * ((RationalScalar) s).getUp();
        down = down * ((RationalScalar) s).getDown();

        reduceByDivider(up, down);
        checkIfDownNegative();
        return RationalScalar.createRational(up, down);
    }

    @Override
    public Scalar pow(int exponent) {
        int tempUp = up;
        int tempDown = down;

        if (exponent == 0)
            return RationalScalar.createRational(1, 1);


        for (int i = 1; i < exponent; i++) {
            tempUp = up * up;
            tempDown = down * down;
        }

        if (exponent < 0) {
            int temp = tempUp;
            tempUp = tempDown;
            tempDown = temp;
            checkIfDownNegative();
        }
        return RationalScalar.createRational(tempUp, tempDown);
    }

    @Override
    public Scalar neg() {
        up = -1 * up;
        checkIfDownNegative();
        return this;
    }

    @Override
    public boolean equals(Scalar s) {
        return up == ((RationalScalar) s).getUp() && down == ((RationalScalar) s).getDown();
    }

    @Override
    public Scalar mulByInt(int num) {
        up = up * num;
        return this;
    }

    @Override
    public boolean isZero() {
        return up == 0;
    }

    @Override
    public boolean isNegetive() {
        return down < 0 || up < 0;
    }

    @Override
    public String toString() {
        String s = "";
        if (down == 1) {
            if (up == 1)
                return s;
            return s + up;
        }
        return s + up + "/" + down;
    }
}