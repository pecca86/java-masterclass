package staticdemo;

public class StaticInitDemo {
    public static void main(String[] args) {
        System.out.println("Main called");
        StaticInit staticInit = new StaticInit();
        staticInit.testMethod();
        System.out.println("Owner is: " + staticInit.owner);
    }
}
