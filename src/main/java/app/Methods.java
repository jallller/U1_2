package app;

public class Methods {
    //5.1:
    // Static method to double a value
    public static int doubleValue(int x) {
        return x * 2;
    }

    // Static method to check if a value is odd
    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }

    // Static method to increment a value by 1
    public static int increment(int x) {
        return x + 1;
    }


//    import java.util.Arrays;
//
//    public class MapWithMethodReferences {
//
//        // Method to apply transformation using MyTransformingType
//        public static int[] map(int[] a, MyTransformingType op) {
//            return Arrays.stream(a)
//                    .map(op::transform)  // Using method reference
//                    .toArray();
//        }
//
//        public static void main(String[] args) {
//            int[] numbers = {1, 2, 3, 4, 5};
//
//            // Using method reference for doubling values
//            int[] doubled = map(numbers, FunctionalMethods::doubleValue);
//            System.out.println("Doubled: " + Arrays.toString(doubled));  // Output: [2, 4, 6, 8, 10]
//
//            // Using method reference for incrementing values
//            int[] incremented = map(numbers, FunctionalMethods::increment);
//            System.out.println("Incremented: " + Arrays.toString(incremented));  // Output: [2, 3, 4, 5, 6]
//        }
//    }
//
//    import java.util.Arrays;
//
//    public class FilterWithMethodReferences {
//
//        // Method to filter values using MyValidatingType
//        public static int[] filter(int[] a, MyValidatingType op) {
//            return Arrays.stream(a)
//                    .filter(op::validate)  // Using method reference
//                    .toArray();
//        }
//
//        public static void main(String[] args) {
//            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//            // Using method reference to filter odd numbers
//            int[] oddNumbers = filter(numbers, FunctionalMethods::isOdd);
//            System.out.println("Odd Numbers: " + Arrays.toString(oddNumbers));  // Output: [1, 3, 5, 7, 9]
//        }
//
//        public class FunctionalMethods {
//
//            // Static method to triple a value
//            public static int tripleValue(int x) {
//                return x * 3;
//            }
//        }
//
//        public class CustomMethodReferenceExample {
//
//            public static void main(String[] args) {
//                int[] numbers = {1, 2, 3, 4, 5};
//
//                // Using method reference for tripling values
//                int[] tripled = MapWithMethodReferences.map(numbers, FunctionalMethods::tripleValue);
//                System.out.println("Tripled: " + Arrays.toString(tripled));  // Output: [3, 6, 9, 12, 15]
//            }
//        }


}
