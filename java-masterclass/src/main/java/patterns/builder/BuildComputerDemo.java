package patterns.builder;

public class BuildComputerDemo {
    public static void main(String[] args) {
        Computer myComputer = new Computer.ComputerBuilder(
                "Dell",
                1500,
                64
        )
                .setHasGraphicsCard(true)
                .setHasWifiAdapter(true)
                .build();

        System.out.println(myComputer);
    }
}
