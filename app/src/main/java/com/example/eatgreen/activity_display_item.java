package com.example.eatgreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class activity_display_item extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_item);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);

        // Get the data
        String dishName = getIntent().getStringExtra("dish_name");
        String dishIngredients = getIntent().getStringExtra("dish_ingredients");
        String dishPrice = getIntent().getStringExtra("dish_price");
        String dishAllergens = getIntent().getStringExtra("dish_allergens");
        String dishCalories = getIntent().getStringExtra("dish_calories");
        String dishDescription = getIntent().getStringExtra("dish_description");
        int dishImageResId = getIntent().getIntExtra("dish_image", -1);

        // Display the data
        TextView nameTextView = findViewById(R.id.dish_name);
        TextView ingredientsTextView = findViewById(R.id.dish_ingredients);
        TextView priceTextView = findViewById(R.id.dish_price);
        TextView allergensTextView = findViewById(R.id.dish_allergens);
        TextView caloriesTextView = findViewById(R.id.dish_calories);
        TextView descriptionTextView = findViewById(R.id.dish_description);
        ImageView dishImageView = findViewById(R.id.dish_image);

        nameTextView.setText(dishName);
        ingredientsTextView.setText("Ingredients: " + dishIngredients);
        priceTextView.setText("Price: " + dishPrice);
        allergensTextView.setText("Allergens: " + dishAllergens);
        caloriesTextView.setText("Calories: " + dishCalories);
        descriptionTextView.setText(dishDescription);

        if (dishImageResId != -1) {
            dishImageView.setImageResource(dishImageResId);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        // Handle toolbar item selection
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }
}
