package abstracclasses;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Eating some fine looking dog pussy...");
    }

    @Override
    public void fuck() {
        System.out.println("Fucking like a wildebeest!");
    }
}
