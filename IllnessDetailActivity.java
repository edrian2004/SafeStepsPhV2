package com.example.safestepsphv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IllnessDetailActivity extends AppCompatActivity {

    private TextView name;
    private TextView desc;
    private TextView med;

    private ImageView homeicon;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness_detail);

        // back arrow click – open Home activity
        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change "Home.class" to whatever your home screen Activity is called
                Intent intent = new Intent(IllnessDetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        homeicon = findViewById(R.id.iconHome);
        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IllnessDetailActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });


        // link UI components
        name = findViewById(R.id.textName);
        desc = findViewById(R.id.textDescription);
        med = findViewById(R.id.textMedicine);


        // get the data from the intent sent from MainActivity / Adapter
        Intent intent = getIntent();
        if (intent != null) {
            String illnessName = intent.getStringExtra("name");
            String illnessDesc = intent.getStringExtra("description");
            String illnessMed = intent.getStringExtra("medicine");

            // set values to TextViews
            name.setText(illnessName != null ? illnessName : "");
            desc.setText(illnessDesc != null ? illnessDesc : "");
            med.setText("Medicine: " + (illnessMed != null ? illnessMed : ""));
        }
    }
}
