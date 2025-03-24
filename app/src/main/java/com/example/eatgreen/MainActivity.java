package com.example.eatgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar myToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        TextView displayTextView = (TextView) findViewById(R.id.DisplayText);

        if (item.getItemId() == R.id.home_page)
        {
            Intent favIntent = new Intent(this, activity_display_home.class);
            startActivity(favIntent);
            return true;
        }
        else if(item.getItemId() == R.id.about_page)
        {
            displayTextView.setText("About View!");
            return true;
        }
        else if(item.getItemId() == R.id.menu_page)
        {
            displayTextView.setText("Menu!");
            return true;
        }
        else if(item.getItemId() == R.id.calorie_page)
        {
            displayTextView.setText("Calorie View!");
            return true;
        }
        else if(item.getItemId() == R.id.sales_page)
        {
            displayTextView.setText("Sales!");
            return true;
        }
        else if(item.getItemId() == R.id.contact_page)
        {
            displayTextView.setText("Contact!");
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }
}