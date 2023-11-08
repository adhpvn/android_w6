package com.example.androidw6_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.appName.text = items[position].name
        holder.rating.text = items[position].rating
        holder.img.setImageResource(items[position].img)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var appName: TextView
        var rating: TextView
        var img: ImageView

        init {
            appName = itemView.findViewById(R.id.appName)
            rating = itemView.findViewById(R.id.rating)
            img = itemView.findViewById(R.id.imageView)
        }

    }
}