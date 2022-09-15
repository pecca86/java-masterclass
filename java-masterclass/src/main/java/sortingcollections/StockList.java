package sortingcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> stock;

    public StockList() {
        this.stock = new LinkedHashMap<>(); // Retains order of insertion
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = stock.getOrDefault(item.getName(), item);
            // Check if item is already in stock
            if (inStock != item) {
                item.adjustStock(inStock.getQuantityInStock()+1);
            }

            stock.put(item.getName(), item);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sell(String item, int quantity) {
        StockItem inStock = stock.getOrDefault(item, null);

        if ( (inStock != null) && (inStock.getQuantityInStock() >= quantity) && (quantity > 0) ) {
            inStock.adjustStock(-quantity);
            return quantity;
        }

        return 0;
    }

    public StockItem get(String key) {
        return stock.get(key);
    }

    public Map<String, StockItem> Items() {
        // NOTE! Even if you cant modify the HashMap, the items inside it can be modified!!!!
        return Collections.unmodifiableMap(stock); // So user can't modify the Map inside this calss
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, StockItem> item : stock.entrySet()) {
            sb.append(item.getValue() + "\t\t\t - In stock: " + item.getValue().getQuantityInStock() + "\n");
        }

        return sb.toString();
    }
}
