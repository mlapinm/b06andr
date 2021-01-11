package com.example.freon.b3328rec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LittleAdapter extends RecyclerView.Adapter<LittleAdapter.LittleViewHolder> {
    ArrayList<LittleItem> littleItems;

    public class LittleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public LittleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public LittleAdapter(ArrayList<LittleItem> littleItems) {
        this.littleItems = littleItems;
    }

    @NonNull
    @Override
    public LittleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_item_layout, parent, false);
        LittleViewHolder holder = new LittleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LittleViewHolder holder, int position) {
        holder.textView.setText(littleItems.get(position).getLittle1());
    }

    @Override
    public int getItemCount() {
        return littleItems.size();
    }

}
