package app.opsenioapp.Bikes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.opsenioapp.BikeDatabase.BikePresenter;
import app.opsenioapp.R;
import app.opsenioapp.ShoppingCart.ShoppingCart;


public class SelectBikeView extends Fragment implements ShoppingCart.View{

    private ImageButton shoppingCart;
    private BikesAdapter bikesAdapter;
    private RecyclerView bikesListView;
    private ShoppingCart cart;
    private TextView countInCart;

    public SelectBikeView(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_window, container, false);

        BikePresenter presenter = new BikePresenter(getContext());
        presenter.addData();

        countInCart = view.findViewById(R.id.countInCart);

        cart = ShoppingCart.getInstance();
        cart.setShoppingCart(this, this.getContext(), presenter);

        bikesAdapter = new BikesAdapter(presenter.fetchBike(), cart);
        bikesListView = view.findViewById(R.id.bikeListView);
        bikesListView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        bikesListView.setAdapter(bikesAdapter);

        shoppingCart = view.findViewById(R.id.cart);
        shoppingCart.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_selectBike_to_shoppingCartView);
        });

        return view;
    }

    @Override
    public void updateCountInShoppingCart(int number) {
        countInCart.setText(String.valueOf(number));
    }
}
