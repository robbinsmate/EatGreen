package com.example.eatgreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_counter extends AppCompatActivity {

    private LinearLayout counterLayout;
    private TextView totalCaloriesDisplay;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_counter);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);

        counterLayout = findViewById(R.id.counterDisplayLayout); // Make sure to define this LinearLayout in your XML
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

    @SuppressLint("SetTextI18n")
    private void displayCounterItems() {
        int totalCalories = 0;

        // Clear previous counter layout items
        counterLayout.removeAllViews();

        // Inflate the dish cards for each dish in the counter
        LayoutInflater inflater = LayoutInflater.from(this);

        for (DishList dish : DishCounter.getInstance().getDishes()) {
            // Inflate the dish card layout
            View dishCard = inflater.inflate(R.layout.menu_dish_card, counterLayout, false);

            // Set the dish data into the card
            TextView dishName = dishCard.findViewById(R.id.dish_name);
            TextView dishIngredients = dishCard.findViewById(R.id.dish_ingredients);
            TextView dishPrice = dishCard.findViewById(R.id.dish_price);
            TextView dishAllergens = dishCard.findViewById(R.id.dish_allergens);
            TextView dishCalories = dishCard.findViewById(R.id.dish_calories);
            ImageView dishImage = dishCard.findViewById(R.id.dish_image);
            Button addToCounterButton = dishCard.findViewById(R.id.addToCounterButton); // Button inside the card

            // Populate the dish data
            dishName.setText(dish.getName());
            dishIngredients.setText("Ingredients: " + dish.getIngredients());
            dishPrice.setText("Price: " + dish.getPrice());
            dishAllergens.setText("Allergens: " + dish.getAllergens());
            dishCalories.setText("Calories: " + dish.getCalories());
            dishImage.setImageResource(dish.getImageResId());

            // Set the click listener for "Add to Counter" button
            addToCounterButton.setVisibility(View.GONE); // No need for this in the counter view

            // Add the dish card to the layout
            counterLayout.addView(dishCard);

            // Add to total calories
            totalCalories += Integer.parseInt(dish.getCalories());
        }

        // Update the total calories display
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
