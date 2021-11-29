package app.opsenioapp.ShoppingCartDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoppingList")
public class CartDB {
    @PrimaryKey
    public int id; //bike id
    public int count; //number of bikes

    public CartDB(int id, int count){
        this.id = id;
        this.count = count;
    }
}
