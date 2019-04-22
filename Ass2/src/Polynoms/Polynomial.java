package Polynoms;

import Numbers.RationalScalar;
import Numbers.RealScalar;
import Numbers.Scalar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Polynomial implements PolynomialInterface {

    private List<PolyTerm> polinom;
    private boolean isQ;

    public Polynomial(List<PolyTerm> poly, boolean isQ) {
        polinom = poly;
        Collections.sort(polinom);

        this.isQ = isQ;
    }

    public List<PolyTerm> getPolinom() {
        return polinom;
    }

    @Override
    public Polynomial add(Polynomial poly) {
        List<PolyTerm> terms = poly.getPolinom();
        for (PolyTerm term : terms) {
            int index = containsExponent(term.getExponent());
            if (index != -1)
                polinom.get(index).add(term);
            else
                polinom.add(term);
        }
        Collections.sort(polinom);
        checkZeroes();
        return this;
    }

    @Override
    public Polynomial mul(Polynomial poly) {
        List<PolyTerm> terms = poly.getPolinom();
        List<PolyTerm> temp = new LinkedList<>();
        for (PolyTerm term : terms) {
            for (PolyTerm term1 : polinom)
                temp.add(term.mul(term1));
        }
        polinom = temp;
        Collections.sort(polinom);
        checkZeroes();
        return this;
    }

    @Override
    public Scalar evaluate(Scalar scalar) {//todo: howw
        Scalar s;

        if (isQ)
            s = RationalScalar.createRational(0, 1);

        else
            s = new RealScalar(0);

        for (PolyTerm term : polinom)
            s.add(term.evaluate(scalar));

        return s;
    }

    @Override
    public Polynomial derivate() {
        for (PolyTerm term : polinom)
            term.derivate();
        checkZeroes();
        return this;
    }

    @Override
    public boolean equals(Polynomial poly) {
        List<PolyTerm> terms = poly.getPolinom();

        for (PolyTerm term : terms)
            for (PolyTerm term1 : polinom)
                if (!term.equals(term1))
                    return false;
        return true;
    }

    private void checkZeroes() {
        List<PolyTerm> toRemove = new LinkedList<>();
        for (PolyTerm term : polinom)
            if (term.getScalar().isZero())
                toRemove.add(term);

        for (PolyTerm term : toRemove)
            if (polinom.size() == 1)
                break;
            else
                polinom.remove(term);
    }

    private int containsExponent(int exponent) {
        for (int i = 0; i < polinom.size(); i++)
            if (polinom.get(i).getExponent() == exponent)
                return i;
        return -1;
    }
}
