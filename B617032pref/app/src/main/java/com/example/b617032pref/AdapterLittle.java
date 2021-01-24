package com.example.b617032pref;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLittle extends RecyclerView.Adapter<AdapterLittle.ViewHolderLittle> {
    ArrayList<LittleItem> items;

    public class ViewHolderLittle extends RecyclerView.ViewHolder{

        TextView textView1;
        TextView textView2;

        public ViewHolderLittle(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public AdapterLittle(ArrayList<LittleItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderLittle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        ViewHolderLittle vhl = new ViewHolderLittle(view);
        return vhl;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLittle holder, int position) {
        LittleItem littleItem = items.get(position);
        holder.textView1.setText(littleItem.getLine1());
        holder.textView2.setText(littleItem.getLine2());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
