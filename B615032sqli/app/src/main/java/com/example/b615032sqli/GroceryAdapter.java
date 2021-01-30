package com.example.b615032sqli;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {
    private Context context;
    private Cursor cursor;

    public GroceryAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewCount;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name_item);
            textViewCount = itemView.findViewById(R.id.text_view_amount_item);
        }
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.grocery_item,
                parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        if(!cursor.moveToPosition(position)){
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_NAME));
        int amount = cursor.getInt(cursor.getColumnIndex(GroceryContract.GroceryEntry.COLUMN_AMOUNT));
        long id = cursor.getLong(cursor.getColumnIndex(GroceryContract.GroceryEntry._ID));

        holder.textViewName.setText(name);
        holder.textViewCount.setText(String.valueOf(amount));
        holder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void  swapCursor(Cursor newCursor){
        if(cursor != null){
            cursor.close();
        }
        cursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }

}
