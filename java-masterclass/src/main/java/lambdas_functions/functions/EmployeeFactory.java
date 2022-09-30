package lambdas_functions.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EmployeeFactory {
    private static final List<Employee> employees = List.of(
            new Employee("John-20", 20),
            new Employee("Kajsa-36", 36),
            new Employee("Ida-25", 25),
            new Employee("Ida-55", 55),
            new Employee("Ida-15", 15),
            new Employee("Ida-22", 22)
    );

    public EmployeeFactory() {
    };

    public static List<Employee> getEmployees() {
        return employees;
    }
}
