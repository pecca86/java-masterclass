package composition;

public abstract class Furniture {
    private int widht;
    private int weight;

    public Furniture(int widht, int weight) {
        this.widht = widht;
        this.weight = weight;
    }

    public int getWidht() {
        return widht;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "toString() Not implemented in this class";
    }
}
