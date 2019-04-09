package Numbers;

public interface Scalar {

    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar pow(int exponent);
    Scalar neg();
    boolean equals(Scalar s);
}