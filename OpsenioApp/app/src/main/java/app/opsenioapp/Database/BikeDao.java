package app.opsenioapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BikeDao {
    @Query("SELECT * FROM bikesList")
    List<BikeDB> getAll();

    @Query("SELECT * FROM bikesList WHERE id=:id")
    BikeDB findPersonById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBike(BikeDB bike);

    @Delete
    void deleteBike(BikeDB bike);
}
