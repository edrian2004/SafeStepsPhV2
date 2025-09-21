package com.example.safestepsphv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<IllnessBean> illnessList = new ArrayList<>();
    private IllnessAdapter adapter;

    private ImageView homeicon;

    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // back arrow click – open Home activity
        backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change "Home.class" to whatever your home screen Activity is called
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        homeicon = findViewById(R.id.iconHome);
        homeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        });


        listView = findViewById(R.id.listViewIllness);
        adapter = new IllnessAdapter(this, illnessList);
        listView.setAdapter(adapter);

        fetchIllnesses();
    }

    private void fetchIllnesses() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<IllnessResponse> call = apiService.getIllnesses();

        call.enqueue(new Callback<IllnessResponse>() {
            @Override
            public void onResponse(Call<IllnessResponse> call, Response<IllnessResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    illnessList.clear();
                    illnessList.addAll(response.body().getIllnesses());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IllnessResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
