package com.example.safestepsphv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity {

    Button btnIllness, btnFirstAid, btnAskAI;
    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivProfile = findViewById(R.id.ivProfile);
        btnIllness = findViewById(R.id.btnIllness);
        btnFirstAid = findViewById(R.id.btnFirstAid);

        ivProfile.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        });


        btnIllness.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, MainActivity.class);
            startActivity(intent);
        });

        btnFirstAid.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, FirstAid.class);
            startActivity(intent);
        });


    }
}
