package Polynoms;

import Numbers.Scalar;

public class PolyTerm implements PolyTermInterface, Comparable {

    private Scalar _coeff;
    private int _exp;

    public static PolyTerm getPolyTerm(int exp, Scalar coeff) {
        if (exp >= 0) {
            return new PolyTerm(exp, coeff);
        }
        return null;
    }

    private PolyTerm(int exp, Scalar coeff) {
        _exp = exp;
        _coeff = coeff;
    }


    public Scalar get_coeff() {
        return _coeff;
    }

    public int get_exp() {
        return _exp;
    }

    @Override
    public boolean canAdd(PolyTerm pt) {
        if (_exp == pt.get_exp()) {
            return true;
        }
        return false;
    }

    @Override
    public PolyTerm add(PolyTerm pt) {
        if (canAdd(pt)) {
            _coeff.add(pt.get_coeff());
            return this;
        }
        return null;
    }

    @Override
    public PolyTerm mul(PolyTerm pt) {
        Scalar newScalar = _coeff.mul(pt.get_coeff());
        int newExp = _exp + pt.get_exp();
        PolyTerm newPolyTerm = PolyTerm.getPolyTerm(newExp, newScalar);
        return newPolyTerm;
    }

    @Override
    public Scalar evaluate(Scalar scalar) {
        if (_exp > 0) {
            scalar.pow(_exp);
            scalar.mul(_coeff);
            return scalar;
        }
        return _coeff;
    }

    @Override
    public PolyTerm derivate() {
        return null;
    }

    @Override
    public boolean equals(PolyTerm pt) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
