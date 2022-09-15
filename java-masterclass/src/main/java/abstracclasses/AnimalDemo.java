package abstracclasses;

public class AnimalDemo {

    public static void main(String[] args) {

        Dog dog = new Dog("Pluto");
        dog.eat();
        dog.fuck();
        System.out.println(dog.getName());

        Bird bird = new Timo("Timo-Trast");
        bird.eat();
        bird.fuck();
        bird.fly();

        Emil emil = new Emil("Emil-örn");
        emil.eat();
        emil.fly();
        emil.fuck();
    }
}
