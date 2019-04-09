package Polynoms;

import Numbers.Scalar;

public interface PolynomialInterface {

    PolynomialInterface add(PolynomialInterface poly);
    PolynomialInterface mul(PolynomialInterface poly);
    Scalar evaluate(Scalar scalar);
    PolynomialInterface derivate();
    String toString();
    boolean equals(PolynomialInterface poly);
}
