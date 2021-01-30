package com.example.b621062recy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LittleAdapter extends RecyclerView.Adapter<LittleAdapter.LittleViewHolder> {
    private Context context;
    private ArrayList<LittleItem> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public LittleAdapter(Context context, ArrayList<LittleItem> items) {
        this.context = context;
        this.items = items;
    }

    public class LittleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textViewCreator;
        public TextView textViewLikes;

        public LittleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textViewCreator = itemView.findViewById(R.id.text_view_creator);
            textViewLikes = itemView.findViewById(R.id.text_view_download);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public LittleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.little_item, parent, false);
        return new LittleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LittleViewHolder holder, int position) {
        LittleItem littleItem = items.get(position);
        String imageUrl = littleItem.getImageUrl();
        String creator = littleItem.getCreator();
        int likes = littleItem.getLikes();

        holder.textViewCreator.setText(creator);
        holder.textViewLikes.setText("Likes: " + likes);
        Picasso.get().load(imageUrl)
                .fit()
                .centerInside()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
