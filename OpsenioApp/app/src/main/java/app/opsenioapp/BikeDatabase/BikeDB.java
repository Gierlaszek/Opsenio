package app.opsenioapp.BikeDatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bikesList")
public class BikeDB {
    @PrimaryKey //(autoGenerate = true)
    public int id;
    public String name;
    public String brand;
    public String color;
    public double price;

    public BikeDB(int id, String name, String brand, String color, double price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
