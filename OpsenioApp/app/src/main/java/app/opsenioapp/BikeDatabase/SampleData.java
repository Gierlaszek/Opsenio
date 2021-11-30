package app.opsenioapp.BikeDatabase;

public class SampleData {

    private BikePresenter presenter;
    public SampleData(BikePresenter presenter){
        this.presenter = presenter;
    }

    public void addSomeData(){
        presenter.storeBike(new BikeDB(
                1,
                "Rower dziecięcy",
                "Kross",
                "Czerwony",
                2000.0
        ));

        presenter.storeBike(new BikeDB(
                2,
                "Rower Rambler R8.0",
                "Romet",
                "Biały",
                999.0
        ));

        presenter.storeBike(new BikeDB(
                3,
                "Rower Rambler R9.0",
                "Romet",
                "Czarny",
                1299.0
        ));

        presenter.storeBike(new BikeDB(
                4,
                "Rower elektryczny",
                "Raymon",
                "Czarny",
                12999.0
        ));

        presenter.storeBike(new BikeDB(
                5,
                "Rower górski",
                "Monteria",
                "Czarny",
                1859.0
        ));

        presenter.storeBike(new BikeDB(
                6,
                "Rower Rambler R6.0",
                "Romet",
                "Czerwony",
                1599.0
        ));

        presenter.storeBike(new BikeDB(
                7,
                "Rower Energy",
                "Orbea",
                "Czarny",
                2499.0
        ));

        presenter.storeBike(new BikeDB(
                8,
                "Rower machine",
                "Manhatan",
                "Czarny",
                2799.0
        ));
    }

}
