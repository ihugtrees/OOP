package Polynoms;

import Numbers.Scalar;

public interface PolyTerm {

    boolean canAdd(PolyTerm pt);
    PolyTerm add(PolyTerm pt);
    PolyTerm mul(PolyTerm pt);
    Scalar evaluate(Scalar scalar);
    PolyTerm derivate();
    boolean equals(PolyTerm pt);
}
