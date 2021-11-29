package app.opsenioapp.ShoppingCart;


import java.util.ArrayList;

import app.opsenioapp.Database.BikeDB;

//Model
public class ShoppingCart {

    private ArrayList<BikeDB> shoppingList;

    public ShoppingCart(){
        shoppingList = new ArrayList<>() ;
    }

    public void addItem(BikeDB bike){
        shoppingList.add(bike);
    }

    public void removeItem(BikeDB bike){
        shoppingList.remove(bike);
    }
}
