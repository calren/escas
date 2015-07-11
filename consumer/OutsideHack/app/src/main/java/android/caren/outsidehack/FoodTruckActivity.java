package android.caren.outsidehack;

import java.util.ArrayList;

import android.caren.outsidehack.FoodTruck.FoodTruckItemAdapter;
import android.caren.outsidehack.models.FoodTruckModel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FoodTruckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck);

        RecyclerView foodTrucksRecyclerView = (RecyclerView) findViewById(R.id.food_truck_list);
        FoodTruckItemAdapter adapter = new FoodTruckItemAdapter(getFoodTruckList());
        foodTrucksRecyclerView.setAdapter(adapter);
        foodTrucksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<FoodTruckModel> getFoodTruckList() {
        ArrayList<FoodTruckModel> foodTruckModels = new ArrayList<>();
        foodTruckModels
                .add(new FoodTruckModel(
                        0,
                        R.drawable.chairman,
                        "Asian Fusion", "0.3 miles", 4, "Chairman Bao"));
        foodTruckModels.add(new FoodTruckModel(1,
                R.drawable.koja,
                "Japanese Fusion", "0.3 miles", 10, "Koja Kitchen"));
        foodTruckModels.add(new FoodTruckModel(2,
                R.drawable.senor,
                "Mexican", "0.3 miles", 5, "Senor Sisig"));
        foodTruckModels
                .add(new FoodTruckModel(
                        3,
                        R.drawable.frozen,
                        "Ice Cream", "0.3 miles", 2, "Frozen Khusterd"));

        return foodTruckModels;
    }
}
