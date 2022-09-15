package staticdemo;

public class StaticTest {
    private static int num = 0;
    private final int instanceNumber;
    private String name;

    public StaticTest(String name) {
        this.num++;
        this.name = name;
        instanceNumber = num;
    }

    public static int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
