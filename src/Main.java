// Catherine Neely
// CSC 112
// 01.24.25

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Item[] store = setUpStore();
        ArrayList<Item> cart = createCart(store, args);

    }

    public static Item[] setUpStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Vanilla Ice Cream", 6.0);
        store[1] = new Item("Chocolate Ice Cream", 3.0);
        store[2] = new Item("Cookie Ice Cream", 4.0);
        store[3] = new Item("Chocolate Chip Ice Cream", 3.0);
        store[4] = new Item("Strawberry Ice Cream", 2.5);
        return store;
    }
    public static ArrayList<Item> createCart(Item[] store, String[] args) {
        int numberOfItems = Integer.parseInt(args[0]);
        int[] items = new int[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = Integer.parseInt(args[i + 1]);
        }
        ArrayList<Item> cart = new ArrayList<Item>();
        for (int i = 0; i < items.length; i++) {
            cart.add(store[items[i]]);
        }
        return cart;
    }

}

//             System.out.println(cart.get(i).getItemName());