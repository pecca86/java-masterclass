package lambdas_functions.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {
    public static void main(String[] args) {

        Function<Employee, String> upperCaseName = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf('-'));

        BiFunction<String, Employee, String> concatAge = (String name, Employee e) -> {
            return name.concat(" -> " + e.getAge());
        };

        // If used in a chain, the BiFunction needs to come first!
        String upperName = upperCaseName.apply(EmployeeFactory.getEmployees().get(1));
        System.out.println(concatAge.apply(upperName, EmployeeFactory.getEmployees().get(1)));
    }
}
