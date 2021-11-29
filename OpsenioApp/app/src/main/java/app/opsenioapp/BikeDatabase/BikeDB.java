package app.opsenioapp.BikeDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bikesList")
public class BikeDB {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String brand;
    public String color;
    public String price;

    public BikeDB(String name, String brand, String color, String price){
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
