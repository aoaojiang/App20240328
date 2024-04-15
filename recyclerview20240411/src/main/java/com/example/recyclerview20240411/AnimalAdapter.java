package com.example.recyclerview20240411;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview20240411.databinding.ItemBinding;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.Holder> {

    private ItemBinding binding;
    private Context context;
    private int[] icons = {
            R.drawable.dark0,
            R.drawable.dark1,
            R.drawable.dark2,
            R.drawable.dark3,
    };
    private String[] titles;
    private String[] details;

    public AnimalAdapter(Context context) {
        this.context = context;
        titles = context.getResources().getStringArray(R.array.animals);
        details = context.getResources().getStringArray(R.array.details);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class Holder extends RecyclerView.ViewHolder {

        public Holder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBinding.bind(itemView);
        }

        public void bind(int position) {
            binding.ivIcon.setImageResource(icons[position]);
            binding.tvTitle.setText(titles[position]);
            binding.tvDetail.setText(details[position]);
        }
    }
}
