package com.example.eatgreen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activity_display_contact extends AppCompatActivity {

    private EditText emailEditText, messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        // Set up the Toolbar
        Toolbar myToolBar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolBar); // This makes the toolbar your action bar

        // Initialize the views
        emailEditText = findViewById(R.id.email_edit_text);
        messageEditText = findViewById(R.id.message_edit_text);
        sendButton = findViewById(R.id.send_button);

        // Set the send button's onClick listener
        sendButton.setOnClickListener(v -> sendMessage());
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
            Intent aboutIntent = new Intent(activity_display_contact.this, MainActivity.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.about_page) {
            // Navigate to AboutActivity
            Intent aboutIntent = new Intent(activity_display_contact.this, activity_display_about.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.menu_page) {
            Intent aboutIntent = new Intent(activity_display_contact.this, activity_display_menu.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.calorie_page) {
            Intent aboutIntent = new Intent(activity_display_contact.this, activity_display_counter.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.sales_page) {
            Intent aboutIntent = new Intent(activity_display_contact.this, activity_display_menu.class);
            startActivity(aboutIntent);
            return true;
        } else if (itemId == R.id.contact_page) {
            // Navigate to AboutActivity
            Intent contactIntent = new Intent(activity_display_contact.this, activity_display_contact.class);
            startActivity(contactIntent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Method to handle sending the message
    private void sendMessage() {
        String email = emailEditText.getText().toString();
        String message = messageEditText.getText().toString();

        if (email.isEmpty() || message.isEmpty()) {
            // Show a toast if the email or message is empty
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
        } else {
            // Show a toast to confirm the message is sent
            Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_SHORT).show();

            // Clear the email and message fields after submission
            emailEditText.setText("");
            messageEditText.setText("");
        }
    }
}
