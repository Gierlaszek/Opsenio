package app.opsenioapp.ShoppingCartDatabase;

import android.content.Context;

import androidx.room.Database;

import java.util.List;


/*
Presenter
 */

public class ShoppingCartPresenter {

    private CartDao cartDao;

    public ShoppingCartPresenter(Context context){
        CartDatabase cartDatabase = CartDatabase.getDatabase(context);
        this.cartDao = cartDatabase.cartDao();
    }

    public void updateCart(CartDB cart){
        cartDao.update(cart);
    }

    public void storeCart(CartDB cart){
        cartDao.insertCart(cart);
    }

    public CartDB getCartId(int id){
        return cartDao.getSingleCart(id);
    }

    public void removeCart(CartDB cart){
        cartDao.deleteCart(cart);
    }

    public void removeAllCart(){
        cartDao.deleteAll();
    }

    public List<CartDB> fetchCart(){
        return cartDao.getAll();
    }

}
