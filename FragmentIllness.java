package com.example.safestepsphv2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentIllness extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_illness, container, false);
        listView = view.findViewById(R.id.listViewIllness);

        // Create API instance
        ApiService api = ApiClient.getClient().create(ApiService.class);

        // Call your PHP endpoint
        Call<IllnessResponse> call = api.getIllnesses();

        call.enqueue(new Callback<IllnessResponse>() {
            @Override
            public void onResponse(Call<IllnessResponse> call, Response<IllnessResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Use getIllnesses() instead of getItems()
                    List<IllnessBean> illnessList = response.body().getIllnesses();

                    if (illnessList != null && !illnessList.isEmpty()) {
                        IllnessAdapter adapter = new IllnessAdapter(requireContext(), illnessList);
                        listView.setAdapter(adapter);
                    } else {
                        Toast.makeText(requireContext(), "No illnesses found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(requireContext(), "No data available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IllnessResponse> call, Throwable t) {
                Toast.makeText(requireContext(), "API Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("API Response", "Error: " + t.getMessage(), t);
            }
        });

        return view;
    }
}
