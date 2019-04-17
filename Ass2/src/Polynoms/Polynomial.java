package Polynoms;

import Numbers.RationalScalar;
import Numbers.RealScalar;
import Numbers.Scalar;

import java.util.Collections;
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
            for (PolyTerm term1 : polinom)
                if (term.canAdd(term1))
                    term.add(term1);
        }
        checkZeroes();
        return this;
    }

    @Override
    public Polynomial mul(Polynomial poly) {
        List<PolyTerm> terms = poly.getPolinom();
        for (PolyTerm term : terms) {
            for (PolyTerm term1 : polinom)
                term.mul(term1);
        }
        checkZeroes();
        return this;
    }

    @Override
    public Scalar evaluate(Scalar scalar) {//todo: howw
        Scalar s;

        if(isQ)
            s = RationalScalar.createRational(0,1);

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

    private void checkZeroes(){
        for (PolyTerm term : polinom)
            if(term.getExponent() == 0 && term.getScalar().isZero())
                polinom.remove(term);
    }
}
