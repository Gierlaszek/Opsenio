package app.opsenioapp.Bikes;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import app.opsenioapp.Database.BikeDB;
import app.opsenioapp.Database.BikeDao;
import app.opsenioapp.Database.BikeDatabase;

/*
Presenter
 */
public class BikePresenter {

    private BikeDao bikeDao;

    public BikePresenter(Context context){
        BikeDatabase database = BikeDatabase.getDatabase(context);
        this.bikeDao = database.bikeDao();
    }

    public void removeBike(BikeDB bike){
        bikeDao.deleteBike(bike);
    }

    public void storeBike(BikeDB bike){
        bikeDao.insertBike(bike);
    }

    public List<BikeDB> fetchBike(){
        return bikeDao.getAll();
    }
}
