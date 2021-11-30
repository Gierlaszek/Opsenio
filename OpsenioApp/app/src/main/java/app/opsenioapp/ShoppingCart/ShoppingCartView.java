package app.opsenioapp.ShoppingCart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.opsenioapp.R;

public class ShoppingCartView extends Fragment {

    private TextView fullPrice;
    private RecyclerView bikeInCartView;
    private ImageButton back;
    private CartAdapter cartAdapter;
    private ShoppingCart shoppingCart;

    public ShoppingCartView(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        back = view.findViewById(R.id.back);
        fullPrice = view.findViewById(R.id.fullPrice);
        bikeInCartView = view.findViewById(R.id.bikeListInCartView);
        back.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });

        shoppingCart = ShoppingCart.getInstance();

        cartAdapter = new CartAdapter(shoppingCart, fullPrice);
        bikeInCartView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        bikeInCartView.setAdapter(cartAdapter);

        return view;
    }
}
