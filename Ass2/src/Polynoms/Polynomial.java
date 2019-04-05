package Polynoms;

import Numbers.Scalar;

public interface Polynomial {

    Polynomial add(Polynomial poly);
    Polynomial mul(Polynomial poly);
    Scalar evaluate(Scalar scalar);
    Polynomial derivate();
    String toString();
    boolean equals(Polynomial poly);
}
