package object;

import java.io.Console;
import java.util.*;

public class ShoppingCart {

    private List<String> items;
    private Map<String, Integer> countMap;


    public ShoppingCart() {

        if (items == null) {
            this.items = new ArrayList<>();
        }

        if (countMap == null) {
            this.countMap = new HashMap<>();
        }
    }

    public void menu() {
        // Console console = System.console();
        System.out.println();
        System.out.println("Welcome to your shopping cart!");
        System.out.println("*********************************");
        System.out.println();
        System.out.println("Input list for a list of items in your cart");
        System.out.println("Input add to add more items to the list");
        System.out.println("Input delete to remove items from the list ");
        System.out.println("Input quit to quit shopping cart");
        // String keyboardInput = "";
        // keyboardInput = console.readLine(">>>");

    }

    public void userInput() {

        Console console = System.console();
        String keyboardInput = "";
        keyboardInput = keyboardInput.toLowerCase();
        
        while (!keyboardInput.equals("quit")) {   // keyboardInput.toLowerCase() != "quit"
            menu(); 
            
            keyboardInput = console.readLine(">>> ");

            if (keyboardInput.startsWith("add")){

                add(keyboardInput);

            }

            if (keyboardInput.startsWith("delete")){

                delete(keyboardInput);

            }

            if (keyboardInput.startsWith("list")){

                list();

            }
            
            
        }

        System.out.println("Goodbye, thank you for shopping with us");

        



    }

    public void add(String keyboardInput) {

        keyboardInput = keyboardInput.replace(',',' ');

        Scanner scan = new Scanner(keyboardInput.substring(4));
        String tempStorage ="";
        while (scan.hasNext()) {
            tempStorage = scan.next();
            items.add(tempStorage);
            
        }
        scan.close();

        // System.out.println("adding stuff");

    }

    public void delete(String keyboardInput) {

        Scanner scan = new Scanner(keyboardInput.substring(6));
        String deleteIndex = scan.next();
        int indexToDelete = Integer.parseInt(deleteIndex) - 1;
        scan.close();

        if (indexToDelete <= items.size()) {
            if (indexToDelete < 0) {
                System.out.println("Index less than 0");
            } else {

                System.out.printf("%s removed from cart", items.get(indexToDelete));
                items.remove(indexToDelete);
            }
        } else {

            System.out.println("Index out of bound. Delete operation cancelled.");
        }



    }

    public void list() {

        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("%d: %s\r\n", i+1, items.get(i));
            }

            for (String itm : items) {
                countMap.put(itm, countMap.getOrDefault(itm, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                System.out.println(entry.getKey() +": " + entry.getValue());
            }

        }
        else {

            System.out.println("No items in cart");

        }

    }
    
}
