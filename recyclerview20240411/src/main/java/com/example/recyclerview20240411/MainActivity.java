package com.example.recyclerview20240411;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerview20240411.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AnimalAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new AnimalAdapter(this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2);
//        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.rvAnimals.setLayoutManager(layoutManager);
        binding.rvAnimals.setAdapter(adapter);

        binding.cbLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cbLayout.isChecked()) {
                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    binding.rvAnimals.setLayoutManager(layoutManager);
                } else {
                    layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                    binding.rvAnimals.setLayoutManager(layoutManager);

                }
            }
        });
    }
}