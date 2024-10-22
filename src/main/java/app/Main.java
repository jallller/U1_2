package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //ARITMETICOPERATIONS
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

        // MAP
        int[] doubled = map(arr1, x -> x * 2);
        System.out.println("Map doubled values : " + Arrays.toString(doubled));

        // FILTER:
        int[] even = filter(arr1, x -> x % 2 == 0);
        System.out.println("Filtered (only even values): " + Arrays.toString(even));

        //PREDICATE
        //predicate<T> - returnere true eller false

        Predicate<Integer> additionP = x -> x < 10;
        //Tjek
//        Predicate<Integer> Ptest =

        // Demonstrating MemoryStorage with String data
        DataStorage<String> memoryStorage = new MemoryStorage<>();
        String memoryId = memoryStorage.store("Hello, world!");
        String retrievedString = memoryStorage.retrieve(memoryId);
        System.out.println("Retrieved from MemoryStorage: " + retrievedString);

//        // Demonstrating FileStorage with Employee objects
//        DataStorage<Employee> fileStorage = new FileStorage<>();
//        Employee employee = new Employee("John", 30);
//        String fileName = fileStorage.store(employee);
//        Employee retrievedEmployee = fileStorage.retrieve(fileName);
//        System.out.println("Retrieved from FileStorage: " + retrievedEmployee);

        // If you want to implement DatabaseStorage later, you can follow the same pattern

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

    public static int[] map(int[] a, MyTransFormingType op) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }

    public static int[] filter(int[] a, MyValidationType mv) {

        // Temp list
        List<Integer> temp = new ArrayList<>();
        for (int value : a) {
            if (mv.validation(value)) {
                temp.add(value);
            }
        } //Returner et nyt array filtret(a) - returnere nye array (kun even elementer)

        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    interface ArithmeticOperation {
        int perform(int a, int b);
    }

    //3.3:  Use Supplier to create a list of Employee objects based on a list of names
    // like Arrays.asList("John", "Jane", "Jack", "Joe", "Jill").
    public class EmployeeSupplier {
        public static void main(String[] args) {
            // List of employee names
            List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");

            // Supplier to create Employee objects
            Supplier<List<Employee>> employeeSupplier = () -> {
                List<Employee> employees = new ArrayList<>();
                for (String name : names) {
                    employees.add(new Employee(name, 30)); // Example age 30 for simplicity
                }
                return employees;
            };

            // Generate the list of employees
            List<Employee> employees = employeeSupplier.get();

            // Print the employee list
            System.out.println(employees);
        }

        //3.4: Use Consumer to print the list of Employee objects.
        public class EmployeeConsumer {
            public static void main(String[] args) {
                // List of Employee objects
                List<Employee> employees = List.of(
                        new Employee("John", 30),
                        new Employee("Jane", 28),
                        new Employee("Jack", 35)
                );

                // Consumer to print Employee details
                Consumer<Employee> printEmployee = e -> System.out.println(e);

                // Iterate and print each employee
                employees.forEach(printEmployee);
            }


            //3.5:
            public class EmployeeToNameFunction {
                public static void main(String[] args) {
                    // List of Employee objects
                    List<Employee> employees = List.of(
                            new Employee("John", 30),
                            new Employee("Jane", 28),
                            new Employee("Jack", 35)
                    );

                    // Function to convert Employee to name (String)
                    Function<Employee, String> getName = e -> e.getName();

                    // Convert employee list to name list
                    List<String> names = employees.stream()
                            .map(getName)
                            .collect(Collectors.toList());

                    // Print the list of names
                    System.out.println(names); // Output: [John, Jane, Jack]
                }
            }

            //3.6: Use Predicate to check if a given employee is older than 18.
            public class EmployeeAgePredicate {
                public static void main(String[] args) {
                    Employee employee = new Employee("John", 30);

                    // Predicate to check if the employee is older than 18
                    Predicate<Employee> isOlderThan18 = e -> e.getAge() > 18;

                    // Check and print result
                    System.out.println(isOlderThan18.test(employee)); // Output: true
                }
            }

        }
    }
}
