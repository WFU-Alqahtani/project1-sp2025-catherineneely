// Catherine Neely
// CSC 112
// 01.24.25

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Item[] store = setUpStore();
        ArrayList<Item> cart = createCart(store, args);
        printReceiptInOrder(cart);
        emptyCartReverseOrder(cart);
    }
    // The setUpStore method sets up the ice cream flavors in the store using the Item object.
    public static Item[] setUpStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Vanilla Ice Cream       ", 2.5);
        store[1] = new Item("Chocolate Ice Cream     ", 2.5);
        store[2] = new Item("Cookie Ice Cream        ", 4.5);
        store[3] = new Item("Chocolate Chip Ice Cream", 4.0);
        store[4] = new Item("Strawberry Ice Cream    ", 3.0);
        return store;
    }
    // The creatCart method creates the user's cart from the arguments input in the terminal, with
    // the first number being the total number of items and the following numbers corresponding
    // to the flavors.
    public static ArrayList<Item> createCart(Item[] store, String[] args) {
        int numberOfItems = Integer.parseInt(args[0]);
        int[] items = new int[numberOfItems];
        // This loop fills the "items" array with the arguments from terminal.
        for (int i = 0; i < numberOfItems; i++) {
                items[i] = Integer.parseInt(args[i + 1]);
        }
        ArrayList<Item> cart = new ArrayList<>();
        // This loop adds the items to the "cart" ArrayList.
        for (int i = 0; i < items.length; i++) {
            cart.add(store[items[i]]);
        }
        return cart;
    }
    // The printReceiptInOrder method prints the items in the user's cart and their price.
    // It then calculates and prints the subtotal, tax, and total cost.
    public static void printReceiptInOrder(ArrayList<Item> cart) {
        System.out.println("""
                Receipt
                ----------------------------------------
                Item                               Price""");
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("%s %15.2f\n", cart.get(i).getItemName(),
                    cart.get(i).getItemPrice());
        }
        double subtotal = 0;
        for (int i = 0; i < cart.size(); i++) {
            subtotal+=cart.get(i).getItemPrice();
        }
        double total = subtotal + (subtotal * 0.05);
        System.out.printf("""
                ----------------------------------------
                (a) Subtotal: %.2f
                (b) Sales Tax: 5%%
                (c) Total: %.2f
                """, subtotal, total);
    }
    // The emptyCartReverseOrder method empties the user's cart by removing the items in the
    // backwards order they were put into the cart.
    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("\nRemoving all items from the cart in backwards order...");
        for(int i = cart.size() - 1; i >= 0; i--) {
            System.out.println("Removing: " + cart.get(i).getItemName());
        }
        System.out.println("The cart has been emptied.");
    }
}
