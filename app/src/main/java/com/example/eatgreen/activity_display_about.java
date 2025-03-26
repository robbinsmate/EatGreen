package com.example.eatgreen;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_about);

        // Set up the Toolbar for About page
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);  // Set this toolbar as the ActionBar

        // Enable the back button (up button)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);  // Back button functionality
        }
    }
}
