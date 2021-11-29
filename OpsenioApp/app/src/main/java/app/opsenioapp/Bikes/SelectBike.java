package app.opsenioapp.Bikes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.opsenioapp.R;
import app.opsenioapp.ShoppingCart.ShoppingCart;

/*
View
 */
public class SelectBike extends Fragment {

    private ImageButton shoppingCart;
    private BikesAdapter bikesAdapter;
    private RecyclerView bikesListView;
    private ShoppingCart cart;

    public SelectBike(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_window, container, false);

        BikePresenter presenter = new BikePresenter(getContext());

        bikesAdapter = new BikesAdapter(presenter.fetchBike(), cart);
        bikesListView = view.findViewById(R.id.bikeListView);
        bikesListView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        bikesListView.setAdapter(bikesAdapter);

        shoppingCart = view.findViewById(R.id.cart);
        shoppingCart.setOnClickListener(v -> {
            //open shopping cart
        });

        return view;
    }

}
