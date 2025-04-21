package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        // Set a custom title on the toolbar
        getSupportActionBar().setTitle("Menu");

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
        dishListArray.add(new DishList("Spiced Lentil Soup", "Lentils, Spices, Vegetable Broth", "£5.99", "V, Ve, D", "200"));
        dishListArray.add(new DishList("Crispy Sweet Potato Fries", "Sweet Potatoes, Olive Oil, Spices", "£4.99", "V, Ve, G", "220"));
        dishListArray.add(new DishList("Stuffed Mushrooms", "Mushrooms, Quinoa, Garlic, Herbs", "£6.49", "Ve, D, G", "240"));

        dishListArray.add(new DishList("Salmon with Asparagus", "Fresh Salmon, Asparagus, Lemon", "£14.99", "D, G", "500"));
        dishListArray.add(new DishList("Grilled Vegetable Skewers", "Zucchini, Bell Peppers, Mushrooms, Olive Oil", "£11.99", "V, Ve, G", "350"));
        dishListArray.add(new DishList("Quinoa-Stuffed Bell Peppers", "Quinoa, Vegetables, Spices", "£12.99", "V, Ve, D, G", "400"));

        dishListArray.add(new DishList("Vegan Chocolate Cake", "Cocoa, Almond Flour, Agave Syrup", "£4.99", "V, D", "220"));
        dishListArray.add(new DishList("Coconut Mango Panna Cotta", "Coconut Milk, Mango Puree, Agar Agar", "£5.99", "V, D, G", "200"));
        dishListArray.add(new DishList("Lemon Sorbet", "Lemon, Sugar, Water", "£3.99", "V, D, G", "150"));
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

            // Inflate the dish card
            View dishCard = inflater.inflate(R.layout.menu_dish_card, sectionLayout, false);


            // Set the dish data into the card
            TextView dishName = dishCard.findViewById(R.id.dish_name);
            TextView dishIngredients = dishCard.findViewById(R.id.dish_ingredients);
            TextView dishPrice = dishCard.findViewById(R.id.dish_price);
            TextView dishAllergens = dishCard.findViewById(R.id.dish_allergens);
            TextView dishCalories = dishCard.findViewById(R.id.dish_calories);

            dishName.setText(dish.getName());
            dishIngredients.setText("Ingredients: " + dish.getIngredients());
            dishPrice.setText("Price: " + dish.getPrice());
            dishAllergens.setText("Allergens: " + dish.getAllergens());
            dishCalories.setText("Calories: " + dish.getCalories());

            // Add the dish card to the section layout
            sectionLayout.addView(dishCard);
        }
    }
}
