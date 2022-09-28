package lambdas_functions.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {

    public static void main(String[] args) {

        Employee p = new Employee("John-20", 20);
        Employee p1 = new Employee("Kajsa-36", 36);
        Employee p2 = new Employee("Ida-25", 25);
        Employee p3 = new Employee("Ida-55", 55);
        Employee p4 = new Employee("Ida-15", 15);
        Employee p5 = new Employee("Ida-22", 22);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(p);
        employeeList.add(p1);
        employeeList.add(p2);
        employeeList.add(p3);
        employeeList.add(p4);
        employeeList.add(p5);

        printEmployeesAgeFilter(employee -> employee.getAge() < 30, employeeList);

        // Using an anonymous class instead of a lambda
        printEmployeesAgeFilter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 30;
            }
        }, employeeList);


        // INT PREDICATE
        IntPredicate gtTen = i -> i > 10;
        IntPredicate ltHundred = i -> i < 100;
        System.out.println(gtTen.test(11)); // true, 11 > 10

        // Predicate chaining
        int myInt = 500;
        boolean gt10lt100 = gtTen
                .and(ltHundred)
                .test(myInt);

        // Both need to be true, for final result to be true
        System.out.println("Accepted?> " + gt10lt100);


        // SUPPLIER
        Random random = new Random();
        Supplier<Integer> randSupplier = () -> random.nextInt(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(randSupplier.get());
        }

    }

    public static void printEmployeesAgeFilter(Predicate<Employee> isUnderThirty, List<Employee> employees) {
        System.out.println("================");
        employees.stream()
                .filter(isUnderThirty)
                .forEach(System.out::println);
    }
}
