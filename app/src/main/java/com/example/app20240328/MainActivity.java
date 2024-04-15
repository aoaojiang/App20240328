package com.example.app20240328;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app20240328.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    String data[] = {"Apple", "Banana", "Orange", "Watermelon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.lv1.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data
        ));

        binding.lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "序号：" + i, Toast.LENGTH_SHORT).show();
                switch (i){
                    case 0://do something
                        break;
                    default:
                        //do sth
                }
            }
        });
    }

    public void onBtnClicked(View view) {
//        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT);
        View view1 = View.inflate(this, R.layout.toast_warning, null);
        TextView toast_tv = view1.findViewById(R.id.tv1);
        toast_tv.setText("自定义的Toast");
        toast.setView(view1);
        toast.show();
    }
}