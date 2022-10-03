package streams;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        this.employeeList.add(e);
    }

    public void printEmployees() {
        employeeList.forEach(System.out::println);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(this.employeeList);
    }
}
