package app.opsenioapp.ShoppingCartDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoppingList")
public class CartDB {
    @PrimaryKey
    public int id;
    public int count;

    public CartDB(int id, int count){
        this.id = id;
        this.count = count;
    }
}
