package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class activity_splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Delay to show splash screen for a few seconds (e.g., 3 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity after the splash screen
                Intent intent = new Intent(activity_splash_screen.this, MainActivity.class);
                startActivity(intent);
                finish();  // Close the splash screen activity so user can't go back to it
            }
        }, 3000);  // 3000ms = 3 seconds
    }
}
