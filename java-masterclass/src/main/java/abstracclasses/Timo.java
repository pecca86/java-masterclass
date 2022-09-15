package abstracclasses;

public class Timo extends Bird {
    public Timo(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Flying by flapping its huge cock");
    }
}
