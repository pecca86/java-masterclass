package abstracclasses;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }


    // Forces the class that implements Animal to create these methods
    public abstract void eat();
    public abstract void fuck();

    public String getName() {
        return name;
    }
}
