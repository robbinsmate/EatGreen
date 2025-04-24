package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class activity_display_menu extends AppCompatActivity {

    private ArrayList<DishList> dishListArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);

        // Populate the dishListArray with sample data
        populateDishList();

        // Initialize the menu sections
        LinearLayout startersLayout = findViewById(R.id.starters);
        LinearLayout mainsLayout = findViewById(R.id.mains);
        LinearLayout dessertsLayout = findViewById(R.id.desserts);

        // Add dishes to the sections
        addDishesToSection(startersLayout, 0, 3, "Starters");
        addDishesToSection(mainsLayout, 3, 6, "Mains");
        addDishesToSection(dessertsLayout, 6, 9, "Desserts");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items
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

    private void populateDishList() {
        // Sample dishes (Added description and image placeholder)
        dishListArray.add(new DishList("Spiced Lentil Soup", "Lentils, Spices, Vegetable Broth", "£5.99", "V, Ve, D", "200", "A warm, spiced dish perfect for winter days.", R.drawable.soup));
        dishListArray.add(new DishList("Crispy Sweet Potato Fries", "Sweet Potatoes, Olive Oil, Spices", "£4.99", "V, Ve, G", "220", "Crispy fries, perfectly seasoned.", R.drawable.fries));
        dishListArray.add(new DishList("Stuffed Mushrooms", "Mushrooms, Quinoa, Garlic, Herbs", "£6.49", "Ve, D, G", "240", "Stuffed mushrooms with quinoa and herbs.", R.drawable.mushroom));

        dishListArray.add(new DishList("Salmon with Asparagus", "Fresh Salmon, Asparagus, Lemon", "£14.99", "D, G", "500", "Grilled salmon served with fresh asparagus.", R.drawable.salmon));
        dishListArray.add(new DishList("Grilled Vegetable Skewers", "Zucchini, Bell Peppers, Mushrooms, Olive Oil", "£11.99", "V, Ve, G", "350", "Grilled vegetables skewered for flavor.", R.drawable.veg));
        dishListArray.add(new DishList("Quinoa-Stuffed Bell Peppers", "Quinoa, Vegetables, Spices", "£12.99", "V, Ve, D, G", "400", "Bell peppers stuffed with quinoa and spices.", R.drawable.pepper));

        dishListArray.add(new DishList("Vegan Chocolate Cake", "Cocoa, Almond Flour, Agave Syrup", "£4.99", "V, D", "220", "Rich and decadent vegan chocolate cake.", R.drawable.cake));
        dishListArray.add(new DishList("Coconut Mango Panna Cotta", "Coconut Milk, Mango Puree, Agar Agar", "£5.99", "V, D, G", "200", "A refreshing coconut and mango dessert.", R.drawable.panna));
        dishListArray.add(new DishList("Lemon Sorbet", "Lemon, Sugar, Water", "£3.99", "V, D, G", "150", "Light and zesty lemon sorbet.", R.drawable.lemon));
    }

    private void addDishesToSection(LinearLayout sectionLayout, int startIndex, int endIndex, String title) {
        LayoutInflater inflater = LayoutInflater.from(this);

        // Add the section title to the layout
        TextView sectionTitle = new TextView(this);
        sectionTitle.setText(title);
        sectionTitle.setTextSize(20);
        sectionTitle.setTextColor(getResources().getColor(android.R.color.black));
        sectionLayout.addView(sectionTitle);

        // Add dishes to the section
        for (int i = startIndex; i < endIndex; i++) {
            DishList dish = dishListArray.get(i);

            // Inflate the dish card layout
            View dishCard = inflater.inflate(R.layout.menu_dish_card, sectionLayout, false);

            // Set the dish data into the card
            TextView dishName = dishCard.findViewById(R.id.dish_name);
            TextView dishIngredients = dishCard.findViewById(R.id.dish_ingredients);
            TextView dishPrice = dishCard.findViewById(R.id.dish_price);
            TextView dishAllergens = dishCard.findViewById(R.id.dish_allergens);
            TextView dishCalories = dishCard.findViewById(R.id.dish_calories);
            ImageView dishImage = dishCard.findViewById(R.id.dish_image);
            Button addToCounterButton = dishCard.findViewById(R.id.addToCounterButton);  // Button inside the card

            dishName.setText(dish.getName());
            dishIngredients.setText("Ingredients: " + dish.getIngredients());
            dishPrice.setText("Price: " + dish.getPrice());
            dishAllergens.setText("Allergens: " + dish.getAllergens());
            dishCalories.setText("Calories: " + dish.getCalories());
            dishImage.setImageResource(dish.getImageResId());

            // Make the dish name clickable and navigate to the dish item page
            dishName.setOnClickListener(v -> {
                // Create an intent to go to the dish item page
                Intent intent = new Intent(activity_display_menu.this, activity_display_item.class);

                // Pass the dish data to the new activity
                intent.putExtra("dish_name", dish.getName());
                intent.putExtra("dish_ingredients", dish.getIngredients());
                intent.putExtra("dish_price", dish.getPrice());
                intent.putExtra("dish_allergens", dish.getAllergens());
                intent.putExtra("dish_calories", dish.getCalories());
                intent.putExtra("dish_description", dish.getDescription());
                intent.putExtra("dish_image_resid", dish.getImageResId());

                // Start the dish item activity
                startActivity(intent);
            });

            // Add the "Add to Counter" button inside the dish card
            addToCounterButton.setOnClickListener(v -> {
                // Add the entire dish to the counter (full details, not just name)
                DishCounter.getInstance().addDish(dish);
                Toast.makeText(activity_display_menu.this, "Added to counter!", Toast.LENGTH_SHORT).show();
            });

            sectionLayout.addView(dishCard);  // Add the card to the section
        }
    }
}
