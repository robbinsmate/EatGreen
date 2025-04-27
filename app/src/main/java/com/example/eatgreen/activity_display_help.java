package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_help);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);

        Button homeButton = findViewById(R.id.goToHomeButton);
        Button menuButton = findViewById(R.id.goToMenuButton);
        Button counterButton = findViewById(R.id.goToCounterButton);
        Button aboutButton = findViewById(R.id.goToAboutButton);
        Button contactButton = findViewById(R.id.goToContactButton);


        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(activity_display_help.this, MainActivity.class);
            startActivity(intent);
        });

        menuButton.setOnClickListener(v -> {
            Intent intent = new Intent(activity_display_help.this, activity_display_menu.class);
            startActivity(intent);
        });

        counterButton.setOnClickListener(v -> {
            Intent intent = new Intent(activity_display_help.this, activity_display_counter.class);
            startActivity(intent);
        });

        aboutButton.setOnClickListener(v -> {
            Intent intent = new Intent(activity_display_help.this, activity_display_about.class);
            startActivity(intent);
        });

        contactButton.setOnClickListener(v -> {
            Intent intent = new Intent(activity_display_help.this, activity_display_contact.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle toolbar item selection
        int itemId = item.getItemId();

        if (itemId == R.id.home_page) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        } else if (itemId == R.id.about_page) {
            startActivity(new Intent(this, activity_display_about.class));
            return true;
        } else if (itemId == R.id.menu_page) {
            startActivity(new Intent(this, activity_display_menu.class));
            return true;
        } else if (itemId == R.id.calorie_page) {
            startActivity(new Intent(this, activity_display_counter.class));
            return true;
        } else if (itemId == R.id.sales_page) {
            startActivity(new Intent(this, activity_display_menu.class));
            return true;
        } else if (itemId == R.id.contact_page) {
            startActivity(new Intent(this, activity_display_contact.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
