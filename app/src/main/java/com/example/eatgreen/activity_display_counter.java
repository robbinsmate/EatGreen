package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_counter extends AppCompatActivity {

    private TextView counterDisplay;
    private TextView totalCaloriesDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_counter);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);

        counterDisplay = findViewById(R.id.counterDisplay);
        totalCaloriesDisplay = findViewById(R.id.totalCalories);

        // Display the current items in the counter
        displayCounterItems();

        // Button to clear items
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(v -> {
            DishCounter.getInstance().clearItems();
            displayCounterItems();
        });

        // Button to go back to the menu
        Button backToMenuButton = findViewById(R.id.backToMenuButton);
        backToMenuButton.setOnClickListener(v -> {
            Intent menuIntent = new Intent(this, activity_display_menu.class);
            startActivity(menuIntent);
        });
    }

    private void displayCounterItems() {
        StringBuilder items = new StringBuilder();
        int totalCalories = 0;

        for (DishList dish : DishCounter.getInstance().getDishes()) {
            items.append(dish.getName()).append("\n");
            totalCalories += Integer.parseInt(dish.getCalories());
        }

        counterDisplay.setText(items.toString());
        totalCaloriesDisplay.setText("Total Calories: " + totalCalories);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home_page) {
            Intent homeIntent = new Intent(this, MainActivity.class);
            startActivity(homeIntent);
            return true;
        } else if (itemId == R.id.about_page) {
            Intent aboutIntent = new Intent(this, activity_display_about.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.menu_page) {
            Intent menuIntent = new Intent(this, activity_display_menu.class);
            startActivity(menuIntent);
            return true;
        } else if (itemId == R.id.calorie_page) {
            Intent calorieIntent = new Intent(this, activity_display_counter.class);
            startActivity(calorieIntent);
            return true;
        } else if (itemId == R.id.sales_page) {
            Intent salesIntent = new Intent(this, activity_display_menu.class);
            startActivity(salesIntent);
            return true;
        } else if (itemId == R.id.contact_page) {
            Intent contactIntent = new Intent(this, activity_display_contact.class);
            startActivity(contactIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
