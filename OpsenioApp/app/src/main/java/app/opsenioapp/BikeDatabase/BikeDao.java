package app.opsenioapp.BikeDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import app.opsenioapp.ShoppingCartDatabase.CartDB;

@Dao
public interface BikeDao {
    @Query("SELECT * FROM bikesList")
    List<BikeDB> getAll();

    @Query("SELECT * FROM bikesList WHERE id=:id LIMIT 1")
    BikeDB getItemId(String id);

    @Query("DELETE FROM bikesList")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBike(BikeDB bike);

    @Delete
    void deleteBike(BikeDB bike);

    @Update(entity = BikeDB.class)
    void update(BikeDB bike);

}
