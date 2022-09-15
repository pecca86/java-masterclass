package staticdemo;

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("First");
        System.out.println(firstInstance.getName() + " instance: " + firstInstance.getNum());

        StaticTest secondInstance = new StaticTest("Second");
        System.out.println(secondInstance.getName() + " instance: " + secondInstance.getNum());

        System.out.println(StaticTest.getNum());

        System.out.println(firstInstance.getInstanceNumber());
        System.out.println(secondInstance.getInstanceNumber());
    }
}
