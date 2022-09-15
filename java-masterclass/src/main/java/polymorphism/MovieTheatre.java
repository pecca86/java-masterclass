package polymorphism;

public class MovieTheatre {
    public static void main(String[] args) {
        Movie myMovie = new ScaryMovie("Knife Fuckers", 2010, "Two guys changed their penises to knives, now bringing terror to all fathers...");

        System.out.println(myMovie.getTitle() + ": " + myMovie.plot());
        myMovie = new Comedy("Oh boy, a tomatoe up my ass 2", 2015, "It's not in the fridge, it's not in the fruitbasket... OH NO! Up my ass again!");

        System.out.println(myMovie.getTitle() + ": " + myMovie.plot());

    }
}
