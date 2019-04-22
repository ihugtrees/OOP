import Numbers.Scalar;
import Polynoms.Polynomial;

import java.util.Scanner;

public class Calculator {

    private static Scanner input = new Scanner(System.in);

    private enum POLYNOMIAL_CASES {Addition, Multiplication, Evaluation, Derivate}

    static Parser _parser;

    public static void main(String[] args) {

        String mathChoice;
        String field;
        _parser = new Parser();

        System.out.println("Welcome to polynomial calculator\n");
        mathMenu();
        mathChoice = input.next();
        while (!mathChoice.equals("5")) {
            System.out.println("Please select the scalar field");
            field = input.next();
            field.toLowerCase();
            if (field.equals("q") || field.equals("r")) {
                operationCases(mathChoice, field);
            }else
                System.out.println("Invalid field");
            mathMenu();
            mathChoice = input.next();
        }
        input.close();
    }

    private static void operationCases(String mathChoice, String field) {
        switch (mathChoice) {
            case "1": {                         //add
                String ans = operations(POLYNOMIAL_CASES.Addition, field);
                answerPrinter(POLYNOMIAL_CASES.Addition, ans);
                break;
            }
            case "2": {                           //mul
                String ans = operations(POLYNOMIAL_CASES.Multiplication, field);
                answerPrinter(POLYNOMIAL_CASES.Multiplication, ans);
                break;
            }
            case "3": {                            //evaluate
                String ans = operations(POLYNOMIAL_CASES.Evaluation, field);
                answerPrinter(POLYNOMIAL_CASES.Evaluation, ans);
                break;
            }
            case "4": {                            //derivate
                String ans = operations(POLYNOMIAL_CASES.Derivate, field);
                answerPrinter(POLYNOMIAL_CASES.Derivate, ans);
                break;
            }
            case "5": {
                break;
            }
            default: {
                System.out.println("illegal choice.");
                break;
            }
        }
    }

    private static void answerPrinter(POLYNOMIAL_CASES action, String ans) {
        System.out.println(ans);
    }

    private static String operations(POLYNOMIAL_CASES action, String field) {
        String ans = "";
        String[] strPolynoms;
        Polynomial[] polynomials;
        System.out.println("You have selected to do: " + action.toString());
        switch (action) {
            case Addition://TODO: working :)
                strPolynoms = getPolyStrFromUser(2);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial addPoly = polynomials[0].add(polynomials[1]);
                ans = _parser.convertPolyToStr(addPoly, "The solution is:");
                break;

            case Multiplication://TODO: working :)
                strPolynoms = getPolyStrFromUser(2);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial multPoly = polynomials[0].mul(polynomials[1]);
                ans = _parser.convertPolyToStr(multPoly, "The solution is:");
                break;

            case Evaluation://TODO: working :)
                strPolynoms = getPolyStrFromUser(1);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Scalar scalar = getScalar(field);
                Scalar evalPoly = polynomials[0].evaluate(scalar);
                ans = _parser.convertScalarToStr(evalPoly, "The solution is:");
                break;

            case Derivate://TODO: empty polinom
                strPolynoms = getPolyStrFromUser(1);
                polynomials = _parser.convertStrToPoly(strPolynoms, field);
                Polynomial derivPoly = polynomials[0].derivate();
                ans = _parser.convertPolyToStr(derivPoly, "The derivative polynomial is:");
        }
        return ans;
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
                + "5. Exit");
    }
}