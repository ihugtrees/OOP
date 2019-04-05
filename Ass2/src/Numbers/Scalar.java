package Numbers;

public interface Scalar {

    Scalar add(Scalar S);
    Scalar mul(Scalar S);
    Scalar pow(int exponent);
    Scalar neg();
    boolean equals(Scalar S);
}