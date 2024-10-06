package service;


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

import object.ShoppingCart;
import cartusers.Users;


public class ShoppingCartDB {

    // to manage the database
    // should contain load a shopping cart, save a shopping cart
    // save, write, read should be here (refer to CSVManagement.java)

    public List<Users> readDB(String filename) throws IOException {

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        List<Users> user = new ArrayList<>();
        String line = "";
        while((line = br.readLine()) != null) {
            System.out.println(line);

            String[] lineData = line.split(", "); // not sure about this
            Users u = new Users(lineData[0]);
            user.add(u);

        }
        br.close();
        fr.close();


        return user;


    }


    public void loadShoppingCart(String filename) {
        
    }
    
}
