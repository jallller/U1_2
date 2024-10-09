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

        //Addition arrays
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};

        ArithmeticOperation add = (a, b) -> a + b;

        int[] addArrResult = operate(arr1, arr2, add);

        for (int result : addArrResult) {
            System.out.println(result);
        }

    }


    public static int performOperation(int a, int b, ArithmeticOperation operation) {
        return operation.perform(a, b);
    }

    public static int[] operate(int[] a, int[] b, ArithmeticOperation operation) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        // Create a result array to store the result of the operations
        int[] result = new int[a.length];

        // Iterate through both arrays and apply the operation element-wise
        for (int i = 0; i < a.length; i++) {
            result[i] = operation.perform(a[i], b[i]);
        }
        return result;
    }

    interface ArithmeticOperation {
        int perform(int a, int b);
    }
}