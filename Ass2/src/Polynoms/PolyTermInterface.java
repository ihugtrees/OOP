package Polynoms;

import Numbers.Scalar;

public interface PolyTermInterface {

    /**
     *
     * @param pt - PolyTerm to check
     * @return - if pt can be added to this PolyTerm
     */
    boolean canAdd(PolyTerm pt);

    /**
     *
     * @param pt - PolyTerm to add
     * @return - The sum of this and pt
     */
    PolyTerm add(PolyTerm pt);

    /**
     *
     * @param pt - PolyTerm to multiply
     * @return - PolyTerm that has been multiplied
     */
    PolyTerm mul(PolyTerm pt);

    /**
     *
     * @param scalar - the input scalar that is gonna be evaluated
     * @return - the answer of evaluation
     */
    Scalar evaluate(Scalar scalar);

    /**
     *
     * @return - the derived PolyTerm
     */
    PolyTerm derivate();

    /**
     *
     * @param pt - PolyTerm to be checked if equals
     * @return - true if equals
     */

    boolean equals(PolyTerm pt);
}
