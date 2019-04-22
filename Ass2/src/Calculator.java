import Numbers.Scalar;
import Polynoms.Polynomial;
import Utilities.Parser;

import java.util.Scanner;

public class Calculator {

    private static Scanner input = new Scanner(System.in);

    private static Parser _parser = new Parser();

    public static void main(String[] args) {

        String mathChoice;
        String field;

        System.out.println("Welcome to polynomial calculator\n");
        mathMenu();
        mathChoice = input.next();
        while (!mathChoice.equals("5")) {
            System.out.println("Please select the scalar field\n" +
                    "Rational (Q) or Real (R)");

            field = input.next();
            field = field.toLowerCase();

            if (field.equals("q") || field.equals("r"))
                operationCases(mathChoice, field);
            else
                System.out.println("Invalid field");

            mathMenu();
            mathChoice = input.next();
        }
        input.close();
    }

    private static void operationCases(String mathChoice, String field) {
        String[] strPolynoms;
        Polynomial[] polynomials;
        switch (mathChoice) {
            case "1": {
                strPolynoms = getPolyStrFromUser(2);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial addPoly = polynomials[0].add(polynomials[1]);
                System.out.println(_parser.convertPolyToStr(addPoly, "The solution is:"));
                break;
            }
            case "2": {
                strPolynoms = getPolyStrFromUser(2);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial multPoly = polynomials[0].mul(polynomials[1]);
                System.out.println(_parser.convertPolyToStr(multPoly, "The solution is:"));
                break;
            }
            case "3": {
                strPolynoms = getPolyStrFromUser(1);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Scalar scalar = getScalar(field);
                Scalar evalPoly = polynomials[0].evaluate(scalar);
                System.out.println(_parser.convertScalarToStr(evalPoly, "The solution is:"));
                break;
            }
            case "4": {
                strPolynoms = getPolyStrFromUser(1);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial derivPoly = polynomials[0].derivate();
                System.out.println(_parser.convertPolyToStr(derivPoly, "The derivative polynomial is:"));
                break;
            }

            default: {
                System.out.println("illegal choice.");
                break;
            }
        }
    }

    /**
     * Get polynoms from the user according to the operation to be execute
     *
     * @param numOfPolys - the number of the polynoms to get from the user
     * @return - array of polynoms, later to be parsed
     */
    private static String[] getPolyStrFromUser(int numOfPolys) {
        input.nextLine();
        String[] polynoms = new String[numOfPolys];
        System.out.println("Input the first polynom: ");
        polynoms[0] = input.nextLine();

        if (numOfPolys > 1) {

            System.out.println("Input the second polynom: ");
            polynoms[1] = input.nextLine();
        }

        return polynoms;
    }

    /**
     * According to the field, returns the scalar, Rational|Real
     *
     * @param field - The field of the scalar
     * @return scalar - The scalar after converted from string
     */
    private static Scalar getScalar(String field) {
        System.out.println("Please insert the scalar");
        String strScalar = input.nextLine();
        Scalar scalar;
        if (field.equals("Q") || field.equals("q")) {
            scalar = _parser.convertStrToRational(strScalar);
        } else {
            scalar = _parser.convertStrToReal(strScalar);
        }
        return scalar;
    }

    private static void mathMenu() {
        System.out.println("Please select an operation:\n"
                + "1. Addition\n"
                + "2. Multiplication\n"
                + "3. Evaluation\n"
                + "4. Derivate\n"
                + "5. Exit" );
    }
}