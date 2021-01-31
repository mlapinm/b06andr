package com.example.b651032kotl

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LittleAdapter(
        private val items: List<LittleItem>
) : RecyclerView.Adapter<LittleAdapter.LittleViewHolder>() {

    class LittleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
        val textView2: TextView = itemView.findViewById(R.id.text_view_2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LittleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.little_item, parent, false)
        return  LittleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LittleViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.imageResource)
        holder.textView1.setText(item.text1)
        holder.textView2.setText(item.text2)

    }

    override fun getItemCount() = items.size

}