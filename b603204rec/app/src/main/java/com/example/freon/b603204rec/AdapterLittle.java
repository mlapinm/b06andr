package com.example.freon.b603204rec;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLittle extends RecyclerView.Adapter<AdapterLittle.ViewHolderLittle> {

    private ArrayList <ItemLittle> itemLittles;


    public static class ViewHolderLittle extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextview1;
        public TextView mTextview2;

        public ViewHolderLittle(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextview1 = itemView.findViewById(R.id.textView);
            mTextview2 = itemView.findViewById(R.id.textView2);
        }
    }

    public AdapterLittle(ArrayList<ItemLittle> itemLittles) {
        this.itemLittles = itemLittles;
    }

    @NonNull
    @Override
    public ViewHolderLittle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        ViewHolderLittle vhl = new ViewHolderLittle(v);
        return vhl;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLittle holder, int position) {
        ItemLittle currentItem = itemLittles.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
//        holder.mImageView.setImageResource(R.drawable.ic_android2);
        holder.mTextview1.setText(currentItem.getmText1());
        holder.mTextview2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return itemLittles.size();
    }
}
