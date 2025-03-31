package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar); // This makes the toolbar your action bar

        // Enable the back button (up button)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Shows the back button
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu); // Inflate the menu for the toolbar
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView displayTextView = findViewById(R.id.DisplayText);

        // Handle menu item selection
        int itemId = item.getItemId();

        if (itemId == R.id.home_page) {
            displayTextView.setText("Home!");
            return true;
        } else if (itemId == R.id.about_page) {
            // Navigate to AboutActivity
            Intent aboutIntent = new Intent(activity_display_about.this, activity_display_about.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.menu_page) {
            displayTextView.setText("Menu!");
            return true;
        } else if (itemId == R.id.calorie_page) {
            displayTextView.setText("Calorie View!");
            return true;
        } else if (itemId == R.id.sales_page) {
            displayTextView.setText("Sales!");
            return true;
        } else if (itemId == R.id.contact_page) {
            // Navigate to AboutActivity
            Intent contactIntent = new Intent(activity_display_about.this, activity_display_contact.class);
            startActivity(contactIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}


