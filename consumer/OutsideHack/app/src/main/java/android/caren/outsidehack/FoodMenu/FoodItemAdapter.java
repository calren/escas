package android.caren.outsidehack.FoodMenu;

import java.util.ArrayList;

import android.caren.outsidehack.R;
import android.caren.outsidehack.models.FoodModel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {

    private ArrayList<FoodModel> foodModels;

    public FoodItemAdapter(ArrayList<FoodModel> foodModels) {
        this.foodModels = foodModels;
    }

    @Override
    public FoodItemAdapter.FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent,
                        false);
        return new FoodItemAdapter.FoodItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodItemAdapter.FoodItemViewHolder holder, int position) {
        FoodModel foodModel = foodModels.get(position);
        holder.name.setText(foodModel.getName());
        holder.price.setText(foodModel.getPrice());
        holder.imageView.setBackgroundResource(foodModel.getPicture());
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView price;
        public TextView quantity;
        public View imageView;

        public FoodItemViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.price = (TextView) itemView.findViewById(R.id.price);
            this.imageView = itemView.findViewById(R.id.food_picture);
        }
    }
}
