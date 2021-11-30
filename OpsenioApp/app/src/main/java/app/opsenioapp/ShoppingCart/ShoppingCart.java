package app.opsenioapp.ShoppingCart;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import app.opsenioapp.BikeDatabase.BikeDB;
import app.opsenioapp.BikeDatabase.BikeDatabase;
import app.opsenioapp.BikeDatabase.BikePresenter;
import app.opsenioapp.ShoppingCartDatabase.CartDB;
import app.opsenioapp.ShoppingCartDatabase.ShoppingCartPresenter;

/**
 * Image from https://www.flaticon.com/free-icon/
 */

public class ShoppingCart {
    private ShoppingCartPresenter presenterShopping;
    private BikePresenter presenterBike;
    private View view;
    private static ShoppingCart instance;

    public void setShoppingCart(View view, Context context, BikePresenter presenter){
        this.presenterShopping = new ShoppingCartPresenter(context);
        this.presenterBike = presenter;
        this.view = view;
        updateNumber();
    }

    public static ShoppingCart getInstance(){
        if(instance == null){
            instance =  new ShoppingCart();
        }
        return instance;
    }

    public void addItem(BikeDB bike){
        CartDB idIsAdded = presenterShopping.getCartId(bike.id);
        if(idIsAdded == null){
            presenterShopping.storeCart(new CartDB(bike.id, 1));
        }else{
            idIsAdded.count += 1;
            presenterShopping.updateCart(idIsAdded);
        }
        updateNumber();
    }

    public List<CartDB> getShoppingCart(){
        return presenterShopping.fetchCart();
    }

    public void removeItem(BikeDB bike){
        CartDB idIsAdded = presenterShopping.getCartId(bike.id);
        if(idIsAdded != null){
            if(idIsAdded.count > 1){
                idIsAdded.count -= 1;
                presenterShopping.updateCart(idIsAdded);
            }else {
                presenterShopping.removeCart(idIsAdded);
            }
        }
        updateNumber();
    }

    public BikePresenter getPresenterBike(){
        return presenterBike;
    }

    public void updateNumber(){
        List<CartDB> cartList= presenterShopping.fetchCart();
        int updateNumber = 0;
        for(int i = 0; i < cartList.size(); i++){
            updateNumber += cartList.get(i).count;
        }
        view.updateCountInShoppingCart(updateNumber);
    }

    public interface View{
        void updateCountInShoppingCart(int number);
    }
}
