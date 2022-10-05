package patterns.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        BuildObject buildObject = new BuildObject("Visit: ");

        buildObject.appendPrefix("www.")
                .appendPayload("pekkaskukestor")
                .appendSuffix(".com");

        System.out.println(buildObject);
    }
}
