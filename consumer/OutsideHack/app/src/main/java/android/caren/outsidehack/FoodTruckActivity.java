package android.caren.outsidehack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import android.caren.outsidehack.FoodTruck.FoodTruckItemAdapter;
import android.caren.outsidehack.models.FoodTruckModel;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class FoodTruckActivity extends AppCompatActivity {

    ArrayList<FoodTruckModel> foodTruckModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck);

        RecyclerView foodTrucksRecyclerView = (RecyclerView) findViewById(R.id.food_truck_list);
        foodTruckModels = getFoodTruckList();
        final FoodTruckItemAdapter adapter = new FoodTruckItemAdapter(foodTruckModels);
        foodTrucksRecyclerView.setAdapter(adapter);
        foodTrucksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.search_toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(foodTruckModels, new CustomComparator());
                adapter.notifyDataSetChanged();

            }
        });
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FoodTruckActivity.this, MenuActivity.class);
                startActivity(i);
            }
        };
    }

    public ArrayList<FoodTruckModel> getFoodTruckList() {
        ArrayList<FoodTruckModel> foodTruckModels = new ArrayList<>();
        foodTruckModels
                .add(new FoodTruckModel(
                        0,
                        R.drawable.chairman,
                        "Asian Fusion", 0.3, 4, "Chairman Bao", getOnClickListener()));
        foodTruckModels.add(new FoodTruckModel(1,
                R.drawable.koja,
                "Japanese Fusion", 0.8, 10, "Koja Kitchen", getOnClickListener()));
        foodTruckModels.add(new FoodTruckModel(2,
                R.drawable.senor,
                "Mexican", .2, 5, "Senor Sisig", getOnClickListener()));
        foodTruckModels
                .add(new FoodTruckModel(
                        3,
                        R.drawable.frozen,
                        "Ice Cream", 1, 2, "Frozen Khusterd", getOnClickListener()));

        return foodTruckModels;
    }

    public class CustomComparator implements Comparator<FoodTruckModel> {
        @Override
        public int compare(FoodTruckModel o1, FoodTruckModel o2) {
            return Double.compare(o1.getLocation(), o2.getLocation());
        }
    }
}
