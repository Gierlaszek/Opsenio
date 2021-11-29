package app.opsenioapp.ShoppingCart;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.opsenioapp.BikeDatabase.BikeDB;
import app.opsenioapp.BikeDatabase.BikePresenter;
import app.opsenioapp.ShoppingCartDatabase.CartDB;
import app.opsenioapp.ShoppingCartDatabase.ShoppingCartPresenter;

//Model
public class ShoppingCart {

    private ShoppingCartPresenter presenterShopping;
    private BikePresenter presenterBike;
    private ArrayList<BikeDB> shoppingList;
    private View view;

    public ShoppingCart(View view, Context context, BikePresenter presenter){
        this.presenterShopping = new ShoppingCartPresenter(context);
        this.presenterBike = presenter;
        shoppingList = new ArrayList<>() ;
        this.view = view;
    }

    public ArrayList<BikeDB> getShoppingList(){



        return shoppingList;
    }

    public void addItem(BikeDB bike){
        /*
        Jesli istnieje już takie id to zwieksz liczbe i dodaj do bazy danych
         */
        CartDB idIsAdded = presenterShopping.getCartId(bike.id);
        if(idIsAdded == null){
            presenterShopping.storeCart(new CartDB(bike.id, 1));
        }else{
            idIsAdded.count += 1;
            presenterShopping.updateCart(idIsAdded);
        }

        shoppingList.add(bike);
    }

    public void removeItem(BikeDB bike){
        shoppingList.remove(bike);
    }

    public void updateNumber(){
        view.updateCountInShoppingCart(shoppingList.size());
    }

    public interface View{
        void updateCountInShoppingCart(int number);
    }
}
