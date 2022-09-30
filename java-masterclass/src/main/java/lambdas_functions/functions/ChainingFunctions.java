package lambdas_functions.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ChainingFunctions {

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

        // First function sets the whole name to upper case
        Function<Employee, String> upperCaseName = employee -> employee.getName().toUpperCase();
        // Second function takes the first name from the string
        Function<String, String> firstName = name -> name.substring(0, name.indexOf('-'));

        // The function that calls the andThen() will run first, and then the second method will run
        // The second method takes as argument the result of the first method
        Function chainedFunction = upperCaseName.andThen(firstName);
        System.out.println(chainedFunction.apply(employeeList.get(0)));


    }
}
