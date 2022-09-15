package abstracclasses;

public abstract class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " swallowing bird-cocks for dinner.");
    }

    @Override
    public void fuck() {
        System.out.println(this.getName() + " managed to put its dick up his anus!");
    }

    public void fly() {
        System.out.println(this.getName() + " is flying like a mad-man!");
    }
}
