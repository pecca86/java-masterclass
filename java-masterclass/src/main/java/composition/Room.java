package composition;

import java.util.ArrayList;
import java.util.List;

public class Room extends Furniture {
    private List<Furniture> furnitures = new ArrayList<>();
    private int width;
    private int length;
    private int height;

    public Room(int width, int weigth) {
        super(width, weigth);
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public int getSquareMeters() {
        return width * length;
    }

    public int getCubicalMeters() {
        return width * length * height;
    }

    public void addFurniture(Furniture furniture) {
        this.furnitures.add(furniture);
    }

    @Override
    public String toString() {
        return "Room{" +
                "furnitures=" + furnitures +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                '}';
    }
}
