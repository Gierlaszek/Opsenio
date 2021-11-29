package app.opsenioapp.BikeDatabase;

import android.content.Context;

import java.util.List;

import app.opsenioapp.BikeDatabase.BikeDB;
import app.opsenioapp.BikeDatabase.BikeDao;
import app.opsenioapp.BikeDatabase.BikeDatabase;
import app.opsenioapp.BikeDatabase.SampleData;

/*
Presenter
 */
public class BikePresenter {

    private BikeDao bikeDao;
    private SampleData data;

    public BikePresenter(Context context){
        BikeDatabase database = BikeDatabase.getDatabase(context);
        this.bikeDao = database.bikeDao();
    }

    public void removeBike(BikeDB bike){
        bikeDao.deleteBike(bike);
    }

    public void removeAllBike() {bikeDao.deleteAll();}

    public void storeBike(BikeDB bike){
        bikeDao.insertBike(bike);
    }

    public List<BikeDB> fetchBike(){
        return bikeDao.getAll();
    }

    public void addData(){
        data = new SampleData(this);
        data.addSomeData();
    }
}
