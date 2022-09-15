package lambdas_functions.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo1 {
    public static void main(String[] args) {

        // Anonymous class 1
        new Thread(new CodeToRun()).start();

        // Anonymous class 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running inside an anonymous class!");
            }
        }).start();

        // Creating an anonymous class with lambda syntax
        new Thread(() -> System.out.println("Running inside a lambda!")).start();

        // Lambda with more logic
        new Thread(()-> {
            System.out.println("Line1");
            System.out.println("Line2");
            System.out.println("Line3");
        }).start();

        EmployeeIda p = new EmployeeIda("John", 20);
        EmployeeIda p1 = new EmployeeIda("Kajsa", 36);
        EmployeeIda p2 = new EmployeeIda("Ida", 25);

        List<EmployeeIda> employeeIdaList = new ArrayList<>();
        employeeIdaList.add(p);
        employeeIdaList.add(p1);
        employeeIdaList.add(p2);

        // Sort the list two ways:
        Collections.sort(employeeIdaList, new Comparator<EmployeeIda>() {
            @Override
            public int compare(EmployeeIda o1, EmployeeIda o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (EmployeeIda e : employeeIdaList) {
            System.out.println(e.getName());
        }


        // Sort using a lambda
        System.out.println("\n=== LAMBDA SORTING ===\n");
        employeeIdaList.add(new EmployeeIda("Aaron", 20));
        System.out.println("\n=== AFTER ADDING AARON ===\n");
        employeeIdaList.stream().forEach(System.out::println);

        Collections.sort(employeeIdaList, Comparator.comparing(EmployeeIda::getName));
        // Collections.sort(employeeIdaList, (a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("\n=== AFTER SORTING ===\n");

        employeeIdaList.stream().forEach(System.out::println);
    }
}


class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable inside: " + this.getClass().getName());
    }
}

class EmployeeIda {
    private String name;
    private int age;

    public EmployeeIda(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeIda{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}