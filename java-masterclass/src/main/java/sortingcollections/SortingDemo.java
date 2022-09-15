package sortingcollections;

import java.util.Collections;

public class SortingDemo {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Dildo", 10);
        stockList.addStock(temp);

        temp = new StockItem("Butter", 0.5);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 4);
        temp.adjustStock(10);
        stockList.addStock(temp);

        temp = new StockItem("Gagball", 10.5);
        stockList.addStock(temp);

        temp = new StockItem("Pillow", 5.5);
        stockList.addStock(temp);

        temp = new StockItem("Anus tap", 1.5);
        temp.adjustStock(10);
        stockList.addStock(temp);

        temp = new StockItem("Leather vest", 110.5);
        stockList.addStock(temp);

        temp = new StockItem("Leather vest", 10);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket shoppingCart = new Basket("Pekka");
        sellItem(shoppingCart, "Anus tap", 3);
        System.out.println(shoppingCart);

        sellItem(shoppingCart, "Cake", 2);
        System.out.println(shoppingCart);

        sellItem(shoppingCart, "Fistfucker pro", 1);
        System.out.println(shoppingCart);


    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " not found in stock!");
            return 0;
        }

        if (stockList.sell(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
