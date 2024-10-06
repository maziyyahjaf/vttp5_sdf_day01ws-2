package object;

import java.io.Console;
import java.util.*;
import java.io.File;
import java.io.IOException;

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
        System.out.println("Input login to login to account");
        System.out.println("Input list for a list of items in your cart");
        System.out.println("Input add to add more items to the list");
        System.out.println("Input delete to remove items from the list ");
        System.out.println("Input users to list registered accounts");
        System.out.println("Input quit to quit shopping cart");
        // String keyboardInput = "";
        // keyboardInput = console.readLine(">>>");

    }

    public void userInput() throws IOException {

        Console console = System.console();
        String keyboardInput = "";
        keyboardInput = keyboardInput.toLowerCase();
        
        while (!keyboardInput.equals("quit")) {   // keyboardInput.toLowerCase() != "quit" ?
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

            if (keyboardInput.startsWith("login")){
                login();
            }

            if (keyboardInput.startsWith("users")){
                users();
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

    public String directory() throws IOException {

        // Scanner scan = new Scanner(keyboardInput.substring(9));
        // String dirPath = scan.next();
        
        Console con1 = System.console();
        String dirPath = con1.readLine("Enter directory: ");



        File directory = new File(dirPath);
        if (directory.exists()) {
            System.out.println("Directory " + directory.toString() + " is already created.");
        } else {
            directory.mkdir();
        }
        // String user;

        // user = login();

        // String dirPathFileName = dirPath + File.separator + user;
        // System.out.println(dirPathFileName);

        // File file = new File(dirPathFileName);

        // if (file.exists()) {
        //     System.out.println("File " + file.toString() + " had already been created");
        // } else {
        //     file.createNewFile();
        // }

        // scan.close();

        return dirPath;

    }


    public File login() throws IOException {

        Console con1 = System.console();
        //Scanner scan = new Scanner(keyboardInput.substring(5));
        String user = con1.readLine("Enter username: ");
        //String user = scan.next();

        String dirPath;
        dirPath = directory();

        String dirPathFileName = dirPath + File.separator + user;
        System.out.println(dirPathFileName);
        
        File file = new File(dirPathFileName);
        if (file.exists()) {
            System.out.println("User " + file.toString() + " already exists.");
        } else {
            file.createNewFile();
        }

        // scan.close();

        return file;


    }

    public void users() throws IOException {

        
        // List<String> results = new ArrayList<String>();

        // File file;
        // file = login(); ->this will go to the each file level. To list files in the directory, should point to the directory

        String dirPath;
        dirPath = directory();


        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();

        if(listOfFiles != null) {
            for (int i = 0; i <listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.printf("%d. %s\r\n", i+1, listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
        }

        // for (File f : listOfFiles) {
        //     if (f.isFile()){
        //         results.add(f.getName());
        //     }
        // }
        // System.out.println(results);

    }
    
}
