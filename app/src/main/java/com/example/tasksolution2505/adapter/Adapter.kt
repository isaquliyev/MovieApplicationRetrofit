package com.example.tasksolution2505.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasksolution2505.R
import com.example.tasksolution2505.model.Movie
import com.example.tasksolution2505.model.Results
import com.squareup.picasso.Picasso

class Adapter(var list: List<Movie>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleId = itemView.findViewById<TextView>(R.id.titleId)
        var posterId = itemView.findViewById<ImageView>(R.id.posterId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleId.setText(list.get(position).title)

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${list.get(position).poster_path}")
            .into(holder.posterId)

    }
}