package sortingcollections;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityInStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void adjustStock(int quantity) {
        if (quantity >= 0) {
            this.quantityInStock += quantity;
        }
    }

    @Override
    public String toString() {
        return this.name + " (" + this.price + "€)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return Double.compare(stockItem.price, price) == 0 && quantityInStock == stockItem.quantityInStock && name.equals(stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantityInStock);
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }

        if (o == null) {
            throw new NullPointerException("Compared object cannot be null!");
        }

        return o.getName().compareTo(o.getName());
    }
}
