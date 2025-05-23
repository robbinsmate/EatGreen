package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar); // This makes the toolbar your action bar
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
            Intent aboutIntent = new Intent(activity_display_about.this, MainActivity.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.about_page) {
            Intent aboutIntent = new Intent(activity_display_about.this, activity_display_about.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.menu_page) {
            Intent aboutIntent = new Intent(activity_display_about.this, activity_display_menu.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.calorie_page) {
            Intent aboutIntent = new Intent(activity_display_about.this, activity_display_counter.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.sales_page) {
            Intent aboutIntent = new Intent(activity_display_about.this, activity_display_menu.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.contact_page) {
            Intent contactIntent = new Intent(activity_display_about.this, activity_display_contact.class);
            startActivity(contactIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}


