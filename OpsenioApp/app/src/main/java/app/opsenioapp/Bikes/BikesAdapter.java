package app.opsenioapp.Bikes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.opsenioapp.BikeDatabase.BikeDB;
import app.opsenioapp.R;
import app.opsenioapp.ShoppingCart.ShoppingCart;

public class BikesAdapter extends RecyclerView.Adapter<BikesAdapter.ViewHolder> {

    private List<BikeDB> bikeList;
    private ShoppingCart cart;

    public BikesAdapter(List<BikeDB> bikeList, ShoppingCart cart){
        this.bikeList = bikeList;
        this.cart = cart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.bike_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(list);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(bikeList.get(position) != null){
            holder.name.setText(bikeList.get(position).name);
            holder.brand.setText(bikeList.get(position).brand);
            holder.color.setText(bikeList.get(position).color);
            holder.price.setText(bikeList.get(position).price);
            holder.add.setOnClickListener(v -> {
                cart.addItem(bikeList.get(position));
                cart.updateNumber();
            });
        }
    }

    @Override
    public int getItemCount() {
        return bikeList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageButton add;
        public TextView name;
        public TextView brand;
        public TextView color;
        public TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            add = (ImageButton) itemView.findViewById(R.id.add);
            name = (TextView) itemView.findViewById(R.id.name);
            brand = (TextView) itemView.findViewById(R.id.brand);
            color = (TextView) itemView.findViewById(R.id.color);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
