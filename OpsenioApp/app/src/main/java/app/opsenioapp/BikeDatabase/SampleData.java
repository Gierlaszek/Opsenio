package app.opsenioapp.BikeDatabase;

public class SampleData {

    private BikePresenter presenter;
    public SampleData(BikePresenter presenter){
        this.presenter = presenter;
    }

    public void addSomeData(){
        presenter.storeBike(new BikeDB(
                "Rower dziecięcy",
                "Kross",
                "Czerwony",
                "2000"
        ));

        presenter.storeBike(new BikeDB(
                "Rower Rambler R8.0",
                "Romet",
                "Biały",
                "999"
        ));

        presenter.storeBike(new BikeDB(
                "Rower Rambler R9.0",
                "Romet",
                "Czarny",
                "1299"
        ));

        presenter.storeBike(new BikeDB(
                "Rower elektryczny",
                "Raymon",
                "Czarny",
                "12 999"
        ));

        presenter.storeBike(new BikeDB(
                "Rower górski",
                "Monteria",
                "Czarny",
                "1859"
        ));

        presenter.storeBike(new BikeDB(
                "Rower Rambler R6.0",
                "Romet",
                "Czerwony",
                "1599"
        ));

        presenter.storeBike(new BikeDB(
                "Rower Energy",
                "Orbea",
                "Czarny",
                "2499"
        ));

        presenter.storeBike(new BikeDB(
                "Rower machine",
                "Manhatan",
                "Czarny",
                "2799"
        ));
    }

}
