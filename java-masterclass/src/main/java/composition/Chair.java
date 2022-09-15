package composition;

public class Chair extends Furniture {
    public Chair(int widht, int weight) {
        super(widht, weight);
    }

    @Override
    public String toString() {
        return "A Chair with the following dimensions: " + "Widht: " + super.getWidht() + ", Weigth: " + super.getWeight();
    }
}
