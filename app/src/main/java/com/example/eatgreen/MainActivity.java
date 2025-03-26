package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView displayTextView = findViewById(R.id.DisplayText);

        // Use if-else or switch statement with valid constants
        int itemId = item.getItemId();

        if (itemId == R.id.home_page) {
            displayTextView.setText("Home!");
            return true;
        } else if (itemId == R.id.about_page) {
            // Start the AboutActivity when About option is selected
            Intent aboutIntent = new Intent(MainActivity.this, activity_display_about.class);
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
            displayTextView.setText("Contact!");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
