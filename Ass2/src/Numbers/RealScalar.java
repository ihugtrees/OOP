package Numbers;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

    private double _value;

    public static Scalar getReal(double a, double b) {
        if (b != 0) {
            return new RealScalar(a, b);
        }
        System.out.println("Denominator can't be 0");
        return null;
    }

    private RealScalar(double a, double b) {
        _value = a / b;
        checkZero();
    }

    private void checkZero() {
        if (Math.abs(_value) < 0.001)
            _value = 0;
    }

    public double get_value() {
        return _value;
    }

    @Override
    public Scalar add(Scalar s) {
        if (s instanceof RealScalar) {
            _value += ((RealScalar) s).get_value();
            checkZero();
            return this;
        }
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        if (s instanceof RealScalar) {
            _value = ((RealScalar) s).get_value() * _value;
            checkZero();
            return this;
        }
        return null;
    }

    @Override
    public Scalar pow(int exponent) {
        if (exponent == 0) {
            _value = 1;
            return this;
        }

        for (int i = 0; i < exponent; i++) {
            _value = _value * _value;
        }
        checkZero();
        if (exponent > 0)
            return this;

        _value = 1/_value;
        checkZero();
        return this;
    }

    @Override
    public Scalar neg() {
        _value = _value*(-1);
        return this;
    }

    @Override
    public boolean equals(Scalar s) {
        if (s instanceof RealScalar) {
            return _value == ((RealScalar) s).get_value();
        }
        return false;
    }

    @Override
    public Scalar mulByInt(int num) {
        _value = _value * num;
        return this;
    }

    public String toString() {//todo:check thiss
        if (_value == (int) _value)
            return ""+(int)_value;

        return ""+Double.parseDouble(new DecimalFormat("###.000").format(_value));
    }
}