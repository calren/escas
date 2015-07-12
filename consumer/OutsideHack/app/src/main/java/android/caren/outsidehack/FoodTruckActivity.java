package android.caren.outsidehack;

import android.app.SearchManager;
import android.caren.outsidehack.FoodTruck.FoodTruckItemAdapter;
import android.caren.outsidehack.models.FoodTruckModel;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FoodTruckActivity extends AppCompatActivity {

    ArrayList<FoodTruckModel> foodTruckModels;

    FoodTruckItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_truck);

        RecyclerView foodTrucksRecyclerView = (RecyclerView) findViewById(R.id.food_truck_list);
        foodTruckModels = getFoodTruckList();
        adapter = new FoodTruckItemAdapter(foodTruckModels);
        foodTrucksRecyclerView.setAdapter(adapter);
        foodTrucksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.search_toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(foodTruckModels, new CustomComparator());
                adapter.notifyDataSetChanged();

            }
        });

        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
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

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }


    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            System.out.println(query);
            //use the query to search your data somehow
            ArrayList<FoodTruckModel> all = getFoodTruckList();
            for (FoodTruckModel ftm : all) {
                if (!ftm.getType().toLowerCase().contains(query)) {
                    foodTruckModels.remove(ftm);
                }
            }
            adapter.notifyDataSetChanged();
        }
    }
}
