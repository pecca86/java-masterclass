package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapDemo {
    public static void main(String[] args) {
        Employee e = new Employee("homo", 40);
        Employee e1 = new Employee("Jack", 10);
        Employee e2 = new Employee("Bill", 22);
        Employee e3 = new Employee("Bull", 32);
        Employee e4 = new Employee("Knull-Göran", 42);

        Employee e5 = new Employee("Reve-Göran", 62);
        Employee e6 = new Employee("Pitt-Göran", 32);

        Department department = new Department("Homot");
        department.addEmployee(e);
        department.addEmployee(e1);
        department.addEmployee(e2);
        department.addEmployee(e3);
        department.addEmployee(e4);

        Department dept = new Department("Assholes");
        dept.addEmployee(e5);
        dept.addEmployee(e6);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        departmentList.add(dept);

        // Print all employees using a flatmap
        departmentList.stream()
                .flatMap(d -> d.getEmployees().stream())
                .forEach(System.out::println);

        // Collect the result
        List<Employee> upperCaseNames = dept.getEmployees().stream()
                .map(em -> new Employee(em.getName().toUpperCase(), em.getAge()))
                .collect(Collectors.toList());
        upperCaseNames.forEach(System.out::println);

        List<String> upperCaseNames2 = department.getEmployees().stream()
                .map(emp -> emp.getName().toUpperCase())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        upperCaseNames2.forEach(System.out::println);

        // Create a HashMap where we group by age
        Map<Integer, List<Employee>> groupedByAge = departmentList.stream()
                .flatMap(de -> de.getEmployees().stream())
                .collect(Collectors.groupingBy(empl -> empl.getAge()));
        System.out.println(groupedByAge);

        // Youngest team member, reduce give an Optional
        departmentList.stream()
                .flatMap(dee -> dee.getEmployees().stream())
                .reduce((ee1, ee2) -> ee1.getAge() < ee2.getAge() ? ee1 : ee2)
                .ifPresent(System.out::println);

        // Streams are lazelly evaluated


    }
}
