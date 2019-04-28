package Polynoms;

import Numbers.Scalar;

public interface PolynomialInterface {

    /**
     *
     * @param poly - Polynomial to add
     * @return - The sum of this and poly
     */
    Polynomial add(Polynomial poly);

    /**
     *
     * @param poly - Polynomial to multiply
     * @return - Polynomial that has been multiplied
     */
    Polynomial mul(Polynomial poly);

    /**
     *
     * @param scalar - the input scalar that is gonna be evaluated
     * @return - the answer of evaluation
     */
    Scalar evaluate(Scalar scalar);

    /**
     *
     * @return - the derived Polynomial
     */
    Polynomial derivate();

    /**
     *
     * @param poly - Polynomial to be checked if equals
     * @return - true if equals
     */
    boolean equals(Polynomial poly);

    /**
     *
     * @return - String represents the Polynomial
     */
    String toString();
}
