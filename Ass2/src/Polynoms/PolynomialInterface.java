package Polynoms;

import Numbers.Scalar;

public interface PolynomialInterface {

    Polynomial add(Polynomial poly);

    Polynomial mul(Polynomial poly);

    Scalar evaluate(Scalar scalar);

    Polynomial derivate();

    String toString();

    boolean equals(Polynomial poly);
}
