package sortingcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> basket;

    public Basket(String name) {
        this.name = name;
        this.basket = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ( item != null && quantity > 0) {
            int inBasket = basket.getOrDefault(item, 0);
            basket.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(basket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<StockItem, Integer> item : basket.entrySet()) {
            sb.append(item.getKey() + ": " + item.getValue() + " items.\t " +  " Total: " + String.format("%.2f", item.getKey().getPrice()* item.getValue()) + "\n");
        }

        return sb.toString();
    }
}
