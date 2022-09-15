package staticdemo;

public class StaticInit {
    public static final String owner;

    // Static init block
    static {
        owner = "Pekka";
        System.out.println("StaticInt init block called");
    }

    public StaticInit() {
        System.out.println("StaticInt constructor called");
    }

    static {
        System.out.println("Second init block called");
    }

    public void testMethod() {
        System.out.println("Testmethod called");
    }
}
