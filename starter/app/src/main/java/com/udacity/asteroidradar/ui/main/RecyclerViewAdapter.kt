package com.udacity.asteroidradar.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.domain.models.Asteroid

class RecyclerViewAdapter(private var asteroidList: List<Asteroid>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById(R.id.title) as TextView
        var date = view.findViewById(R.id.date) as TextView
        var icon = view.findViewById(R.id.smileFace) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val asteroid = asteroidList[position]

//        holder.title.text = asteroid.getTitle()
//        holder.date.text = asteroid.getGenre()
//        holder.icon.setImageIcon() =

    }

    override fun getItemCount()=asteroidList.size



}