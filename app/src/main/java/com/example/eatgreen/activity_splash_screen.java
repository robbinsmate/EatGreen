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

        // Delay the splashscreen
        new Handler().postDelayed(() -> {
            // Start Home screen
            Intent intent = new Intent(activity_splash_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
