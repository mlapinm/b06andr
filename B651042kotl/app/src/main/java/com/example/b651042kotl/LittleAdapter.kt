package com.example.b651042kotl

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LittleAdapter(
        private val items: List<LittleItem>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<LittleAdapter.LittleViewHolder>() {

    inner class LittleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
        val textView2: TextView = itemView.findViewById(R.id.text_view_2)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)

            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
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