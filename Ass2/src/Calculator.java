import java.util.Scanner;

public class Calculator {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int mathChoice;
        String field;

        System.out.println("Welcome to polynomial calculator\n");

        mathMenu();
        mathChoice = input.nextInt();
        while (mathChoice != 5){
            System.out.println("Please select the scalar field");
            field = input.next();
            operationCases(mathChoice);
            mathMenu();
            mathChoice = input.nextInt();
        }
        input.close();
    }

    private static void operationCases(int mathChoice) {
        switch (mathChoice) {
            case 1: {                         //add
                String ans = operations(POLYNOMIAL_CASES.Addition);
                answerPrinter(POLYNOMIAL_CASES.Addition, ans);
                break;
            }
            case 2: {                           //mul
                String ans = operations(POLYNOMIAL_CASES.Multiplication);
                answerPrinter(POLYNOMIAL_CASES.Multiplication, ans);
                break;
            }
            case 3: {                            //evaluate
                String ans = operations(POLYNOMIAL_CASES.Evaluation);
                answerPrinter(POLYNOMIAL_CASES.Evaluation, ans);
                break;
            }
            case 4: {                            //derivate
                String ans = operations(POLYNOMIAL_CASES.Derivate);
                answerPrinter(POLYNOMIAL_CASES.Derivate, ans);
                break;
            }
            case 5:{
                break;
            }
            default: {
                System.out.println("illegal choice.");
                break;
            }
        }
    }

    private static void mathMenu() {
        System.out.println("Please select an operation:\n"
                + "1. Addition\n"
                + "2. Multiplication\n"
                + "3. Evaluation\n "
                + "4. Derivate\n"
                + "5. Exit");
    }
}