package android.caren.outsidehack.FoodTruck;

import java.util.ArrayList;

import android.caren.outsidehack.R;
import android.caren.outsidehack.models.FoodTruckModel;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FoodTruckItemAdapter
        extends RecyclerView.Adapter<FoodTruckItemAdapter.FoodTruckItemViewHolder> {

    private ArrayList<FoodTruckModel> foodTruckModels;

    public FoodTruckItemAdapter(ArrayList<FoodTruckModel> foodTruckModels) {
        this.foodTruckModels = foodTruckModels;
    }

    @Override
    public FoodTruckItemAdapter.FoodTruckItemViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.food_truck_list_item,
                        parent, false);
        return new FoodTruckItemAdapter.FoodTruckItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodTruckItemAdapter.FoodTruckItemViewHolder holder, int position) {
        FoodTruckModel foodTruck = foodTruckModels.get(position);
//        holder.numOfOrdersAhead.setText(foodTruck.getOrdersAhead());
        holder.location.setText(foodTruck.getLocation());
        holder.name.setText(foodTruck.getName());
        holder.type.setText(foodTruck.getType());
        holder.mainLayout.setBackgroundResource(foodTruck.getPicture());
    }

    @Override
    public int getItemCount() {
        return foodTruckModels.size();
    }

    public class FoodTruckItemViewHolder extends RecyclerView.ViewHolder {
        public View mainLayout;
        public TextView location;
        public TextView name;
        public TextView type;
        public TextView numOfOrdersAhead;

        public FoodTruckItemViewHolder(View itemView) {
            super(itemView);
            this.mainLayout = itemView.findViewById(R.id.food_truck_layout);
            this.location = (TextView) itemView.findViewById(R.id.food_truck_location);
            this.name = (TextView) itemView.findViewById(R.id.food_truck_name);
            this.type = (TextView) itemView.findViewById(R.id.food_truck_type);
            this.numOfOrdersAhead = (TextView) itemView.findViewById(R.id.num_of_orders_ahead);
        }
    }
}
