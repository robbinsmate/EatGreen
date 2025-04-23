package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar); // This makes the toolbar your action bar

        // Get buttons from XML
        Button veganButton = findViewById(R.id.veganButton);
        Button vegetarianButton = findViewById(R.id.vegetarianButton);
        Button dairyFreeButton = findViewById(R.id.dairyFreeButton);
        Button lowCalorieButton = findViewById(R.id.lowCalorieButton);
        Button helpButton = findViewById(R.id.helpButton);

        // Set up button click listeners
        veganButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, activity_display_menu.class);
                startActivity(menuIntent);
            }
        });

        vegetarianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, activity_display_menu.class);
                startActivity(menuIntent);
            }
        });

        dairyFreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, activity_display_menu.class);
                startActivity(menuIntent);
            }
        });

        lowCalorieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(MainActivity.this, activity_display_menu.class);
                startActivity(menuIntent);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = new Intent(MainActivity.this, activity_display_help.class);
                startActivity(helpIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item selection
        int itemId = item.getItemId();

        if (itemId == R.id.home_page) {
            Intent aboutIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.about_page) {
            Intent aboutIntent = new Intent(MainActivity.this, activity_display_about.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.menu_page) {
            Intent menuIntent = new Intent(MainActivity.this, activity_display_menu.class);
            startActivity(menuIntent);
            return true;
        } else if (itemId == R.id.calorie_page) {
            Intent calorieIntent = new Intent(MainActivity.this, activity_display_counter.class);
            startActivity(calorieIntent);
            return true;
        } else if (itemId == R.id.sales_page) {
            Intent salesIntent = new Intent(MainActivity.this, activity_display_menu.class);
            startActivity(salesIntent);
            return true;
        } else if (itemId == R.id.contact_page) {
            Intent contactIntent = new Intent(MainActivity.this, activity_display_contact.class);
            startActivity(contactIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
