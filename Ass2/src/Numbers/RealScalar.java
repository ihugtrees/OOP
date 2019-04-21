package Numbers;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

    private double num;

    public RealScalar(double value) {
        num = value;
        checkZero();
    }

    private void checkZero() {
        if (Math.abs(num) < 0.001)
            num = 0;
    }

    public double getNum() {
        return num;
    }

    @Override
    public Scalar add(Scalar s) {
        num += ((RealScalar) s).getNum();
        checkZero();
        return this;
    }

    @Override
    public Scalar mul(Scalar s) {
        num = ((RealScalar) s).getNum() * num;
        checkZero();
        return this;
    }

    @Override
    public Scalar pow(int exponent) {
        if (exponent == 0) {
            num = 1;
            return this;
        }

        for (int i = 0; i < exponent; i++) {
            num = num * num;
        }
        checkZero();
        if (exponent > 0)
            return this;

        num = 1 / num;
        checkZero();
        return this;
    }

    @Override
    public Scalar neg() {
        num = num * (-1);
        return this;
    }

    @Override
    public boolean equals(Scalar s) {
        return num == ((RealScalar) s).getNum();
    }

    @Override
    public Scalar mulByInt(int num) {
        this.num = this.num * num;
        return this;
    }

    @Override
    public boolean isZero() {
        return num == 0.0;
    }

    @Override
    public boolean isNegetive() {
        return num<0;
    }

    public String toString() {//todo:check thiss
        String s = "";
        if (num == (int) num)
            return s + (int) num;

        return s + Double.parseDouble(new DecimalFormat("###.000").format(num));
    }
}