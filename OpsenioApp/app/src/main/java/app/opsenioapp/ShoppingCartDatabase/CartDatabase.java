package app.opsenioapp.ShoppingCartDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import app.opsenioapp.BikeDatabase.BikeDao;
import app.opsenioapp.BikeDatabase.BikeDatabase;

@Database(entities = {CartDB.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {

    private static CartDatabase instance;
    public abstract CartDao cartDao();

    public static CartDatabase getDatabase(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(context.getApplicationContext(), CartDatabase.class, "shoppingList")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
