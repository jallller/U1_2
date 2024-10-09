package app;

public class Main {
    public static void main(String[] args) {

        // Addition
        ArithmeticOperation addition = (a, b) -> a + b;
        int addResult = performOperation(10, 5, addition);
        System.out.println("Addition result: " + addResult);


        // Subtraction
        ArithmeticOperation subtraction = (a, b) -> a - b;
        int subResult = performOperation(10, 5, subtraction);
        System.out.println("Subtraction result: " + subResult);

        //Multiplication
        ArithmeticOperation multiplication = (a, b) -> a * b;
        int multiResult = performOperation(10, 5, multiplication);
        System.out.println("Multiplication result: " + multiResult);

        //Division
        ArithmeticOperation division = (a, b) -> a / b;
        int divResult = performOperation(10, 5, division);
        System.out.println("Division result: " + divResult);


        //Modulus
        ArithmeticOperation modulus = (a, b) -> a % b;
        int modResult = performOperation(10, 5, modulus);
        System.out.println("Modulus result: " + modResult);

        //Power
        ArithmeticOperation power = (a, b) -> (int) Math.pow(a, b);
        int powerResult = performOperation(10, 5, power);
        System.out.println("Power result: " + powerResult);

    }


    public static int performOperation(int a, int b, ArithmeticOperation operation) {
        return operation.perform(a, b);
    }

    interface ArithmeticOperation {
        int perform(int a, int b);
    }
}