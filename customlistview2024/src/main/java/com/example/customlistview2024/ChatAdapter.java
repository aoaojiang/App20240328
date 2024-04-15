package com.example.customlistview2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.customlistview2024.databinding.ItemBinding;

public class ChatAdapter extends BaseAdapter {

    private ItemBinding binding;
    private Context context;
    private String[] titles;
    private String[] messages;
    private String[] times;
    private int[] icons = {
            R.drawable.avatar_1_raster,
            R.drawable.avatar_2_raster,
            R.drawable.avatar_3_raster,
            R.drawable.avatar_4_raster,
            R.drawable.avatar_5_raster,
            R.drawable.avatar_6_raster,
            R.drawable.avatar_7_raster,
            R.drawable.avatar_8_raster,
            R.drawable.avatar_8_raster,
            R.drawable.avatar_8_raster
    };

    public ChatAdapter(Context context) {
        this.context = context;

        titles = context.getResources().getStringArray(R.array.titles);
        messages = context.getResources().getStringArray(R.array.messages);
        times = context.getResources().getStringArray(R.array.times);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return messages[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        binding = ItemBinding.inflate(LayoutInflater.from(context));

        binding.ivIcon.setImageResource(icons[i]);
        binding.tvTitle.setText(titles[i]);
        binding.tvMessage.setText(messages[i]);
        binding.tvTime.setText(times[i]);

        binding.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked " + titles[i] + " icon.", Toast.LENGTH_SHORT).show();
            }
        });
        binding.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked " + titles[i], Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}
