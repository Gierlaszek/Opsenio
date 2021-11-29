package app.opsenioapp.BikeDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BikeDB.class}, version = 1)
public abstract class BikeDatabase extends RoomDatabase {

    private static BikeDatabase instance;
    public abstract BikeDao bikeDao();

    public static BikeDatabase getDatabase(Context context){
        if(instance == null){
            instance =  Room.databaseBuilder(context.getApplicationContext(), BikeDatabase.class, "bikesList")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
