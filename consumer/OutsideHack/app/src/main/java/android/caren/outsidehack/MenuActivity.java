package android.caren.outsidehack;

import java.util.ArrayList;

import android.caren.outsidehack.FoodMenu.FoodItemAdapter;
import android.caren.outsidehack.models.FoodModel;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView menuRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        FoodItemAdapter adapter = new FoodItemAdapter(getMenu());
        menuRecyclerView.setAdapter(adapter);
        menuRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
    }

    public ArrayList<FoodModel> getMenu() {
        ArrayList<FoodModel> foodModels = new ArrayList<>();
        foodModels.add(new FoodModel("Kamikaze Fries", "$6", R.drawable.chicken_bun));
        foodModels.add(new FoodModel("Chicken Rice Bun", "$8", R.drawable.bun));
        foodModels.add(new FoodModel("Kamikaze Fries", "$6", R.drawable.kamikaze));
        foodModels.add(new FoodModel("Chicken Rice Bun", "$8", R.drawable.korean_bowl));
        foodModels.add(new FoodModel("Kamikaze Fries", "$6", R.drawable.tiramisu));
        foodModels.add(new FoodModel("Chicken Rice Bun", "$8", R.drawable.bun));
        return foodModels;
    }
}
