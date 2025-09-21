package com.example.safestepsphv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    TextView tvFullName, tvEmail;
    Button btnLogout;
    ImageView backArrow, iconHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvFullName = findViewById(R.id.tvFullName);
        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);
        backArrow = findViewById(R.id.backArrow);
        iconHome = findViewById(R.id.iconHome);

        // Get user data from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String firstname = prefs.getString("firstname", "");
        String lastname = prefs.getString("lastname", "");
        String email = prefs.getString("email", "");

        tvFullName.setText(firstname + " " + lastname);
        tvEmail.setText(email);

        // Back arrow
        backArrow.setOnClickListener(v -> onBackPressed());

        // Home icon
        iconHome.setOnClickListener(v -> {
            // go to home activity
            startActivity(new Intent(Profile.this, Home.class));
            finish();
        });

        // Logout button
        btnLogout.setOnClickListener(v -> {
            // Clear shared preferences
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(Profile.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
