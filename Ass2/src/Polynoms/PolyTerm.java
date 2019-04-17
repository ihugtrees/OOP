package Polynoms;

import Numbers.Scalar;

public class PolyTerm implements PolyTermInterface, Comparable<PolyTerm> {

    private Scalar scalar;
    private int exponent;

    public static PolyTerm createPolyTerm(Scalar scalar, int exp) {
        if (exp >= 0) {
            return new PolyTerm(scalar, exp);
        }
        System.out.println("Exponent can't be negative");
        return null;
    }

    private PolyTerm(Scalar scalar, int exp) {
        this.scalar = scalar;
        exponent = exp;
    }


    public Scalar getScalar() {
        return scalar;
    }

    public int getExponent() {
        return exponent;
    }

    @Override
    public boolean canAdd(PolyTerm pt) {
        if (exponent == pt.getExponent()) {
            return true;
        }
        return false;
    }

    @Override
    public PolyTerm add(PolyTerm pt) {
        if (canAdd(pt)) {
            scalar.add(pt.getScalar());
            return this;
        }
        return null;
    }

    @Override
    public PolyTerm mul(PolyTerm pt) {
        scalar.mul(pt.getScalar());
        exponent += pt.getExponent();
        return this;
    }

    @Override
    public Scalar evaluate(Scalar scalar) {
        if (exponent == 0)
            return this.scalar;

        scalar.pow(exponent);
        scalar.mul(this.scalar);
        return scalar;
    }

    @Override
    public PolyTerm derivate() {
        if (exponent == 0) {
            scalar.mulByInt(0);
            return this;
        }
        scalar.mulByInt(exponent);
        exponent--;
        return this;
    }

    @Override
    public boolean equals(PolyTerm pt) {
        return exponent == pt.exponent && scalar.equals(pt.scalar);
    }

    public String toString() {
        if (exponent == 0)
            return scalar.toString();
        return scalar.toString() + "x^" + exponent;
    }

    @Override
    public int compareTo(PolyTerm p) {
        return Integer.compare(exponent, p.exponent);
    }
}
