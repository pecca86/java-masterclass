package composition;

public class Sofa extends Furniture {


    public Sofa(int widht, int weight) {
        super(widht, weight);

    }

    public int getWidht() {
        return super.getWidht();
    }

    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public String toString() {
        return "A Sofa with the following dimensions: " + "Widht: " + super.getWidht() + ", Weigth: " + super.getWeight();
    }
}
