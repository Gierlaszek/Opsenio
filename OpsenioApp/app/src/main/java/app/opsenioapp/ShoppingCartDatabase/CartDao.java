package app.opsenioapp.ShoppingCartDatabase;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import app.opsenioapp.BikeDatabase.BikeDB;

@Dao
public interface CartDao {
    @Query("SELECT * FROM shoppingList")
    List<CartDB> getAll();

    @Query("DELETE FROM shoppingList")
    void deleteAll();

    @Query("SELECT * FROM shoppingList WHERE id = :id LIMIT 1")
    CartDB getSingleCart(int id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(CartDB cart);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCart(CartDB cartDB);

    @Delete
    void deleteCart(CartDB cartDB);

}
