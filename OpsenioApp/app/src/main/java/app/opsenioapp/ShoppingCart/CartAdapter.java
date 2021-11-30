package app.opsenioapp.ShoppingCart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.opsenioapp.BikeDatabase.BikeDB;
import app.opsenioapp.BikeDatabase.BikePresenter;
import app.opsenioapp.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    private ShoppingCart shoppingCart;
    private BikePresenter bikePresenter;
    private TextView fullPrice;
    private double full;

    public CartAdapter(ShoppingCart shoppingCart, TextView fullPrice){
        this.shoppingCart = shoppingCart;
        this.bikePresenter = shoppingCart.getPresenterBike();
        this.fullPrice = fullPrice;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.bike_list_in_cart, parent, false);
        CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(list);
        return viewHolder;
    }

    private void fullPrice(){
        full = 0;
        for(int i = 0; i < getItemCount(); i++){
            BikeDB bike = bikePresenter.getBikeById(shoppingCart.getShoppingCart().get(i).id);
            full += shoppingCart.getShoppingCart().get(i).count * bike.price;
        }
        fullPrice.setText(String.valueOf(full));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        if(shoppingCart.getShoppingCart().get(position) != null){
            BikeDB bike = bikePresenter.getBikeById(shoppingCart.getShoppingCart().get(position).id);

            holder.bikeName.setText(bike.brand);
            holder.price.setText(String.valueOf(bike.price * shoppingCart.getShoppingCart().get(position).count));
            holder.count.setText(String.valueOf(shoppingCart.getShoppingCart().get(position).count));
            holder.minus.setOnClickListener(v -> {
                if(getItemCount() > 0){
                    shoppingCart.removeItem(bike);
                    if(getItemCount() == 0){
                        fullPrice.setText("0");
                    }
                    notifyDataSetChanged();
                }
            });

            holder.plus.setOnClickListener(v -> {
                shoppingCart.addItem(bike); //dodajesz rower
                holder.count.setText(String.valueOf(shoppingCart.getShoppingCart().get(position).count));
                holder.price.setText(String.valueOf(bike.price * shoppingCart.getShoppingCart().get(position).count));
                fullPrice();
            });
            fullPrice();
        }
    }

    @Override
    public int getItemCount() {
        return shoppingCart.getShoppingCart().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView bikeName;
        public TextView price;
        public TextView count;
        public ImageButton minus;
        public ImageButton plus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bikeName = itemView.findViewById(R.id.bikeName);
            price = itemView.findViewById(R.id.priceTV);
            count = itemView.findViewById(R.id.countTV);
            minus = itemView.findViewById(R.id.minus);
            plus = itemView.findViewById(R.id.plus);
        }
    }
}
