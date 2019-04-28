package Numbers;

public interface Scalar {

    /**
     *
     * @param s - Scalar to add
     * @return - sum of Scalars
     */
    Scalar add(Scalar s);

    /**
     *
     * @param s - Scalar to multiply
     * @return - the answer after multiplication
     */
    Scalar mul(Scalar s);

    /**
     *
     * @param exponent - the exponent to power
     * @return - Scalar after power
     */
    Scalar pow(int exponent);

    /**
     *
     * @return - the negative Scalar
     */
    Scalar neg();

    /**
     *
     * @param s - Scalar to check
     * @return - if s equals this
     */
    boolean equals(Scalar s);

    /**
     *
     * @param num - integer to multiply
     * @return - Scalar after multiplication
     */
    Scalar mulByInt(int num);

    /**
     *
     * @return - true if Scalar value is zero
     */
    boolean isZero();

    /**
     *
     * @return - if the Scalar is negative
     */
    boolean isNegative();
}