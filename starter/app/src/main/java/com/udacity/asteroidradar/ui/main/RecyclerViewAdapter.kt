package com.udacity.asteroidradar.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.domain.models.Asteroid

class RecyclerViewAdapter(private var asteroidList: List<Asteroid>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById(R.id.title) as TextView
        var date = view.findViewById(R.id.date) as TextView
        var icon = view.findViewById(R.id.smileFace) as ImageView
        var constraint = view.findViewById(R.id.constraint_adapter_item) as ConstraintLayout
    }

    fun submitData(asteroidList: List<Asteroid>) {
        this.asteroidList=asteroidList
        this.notifyDataSetChanged()
//        this.submitData(asteroidList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val asteroid = asteroidList[position]
        holder.title.text = asteroid.codename
        holder.date.text = asteroid.closeApproachDate

        if (asteroid.isPotentiallyHazardous) {
            holder.icon.setImageResource(R.drawable.ic_status_potentially_hazardous)
            holder.icon.contentDescription =holder.icon.context.getString(R.string.potentially_hazardous_asteroid_image)
        }else {
            holder.icon.setImageResource(R.drawable.ic_status_normal)
            holder.icon.contentDescription =holder.icon.context.getString(R.string.not_hazardous_asteroid_image)
        }
        holder.constraint.setOnClickListener {
            val navController = Navigation.findNavController(it)
            val action = MainFragmentDirections.actionShowDetail(asteroid)
            navController.navigate(action)
        }
    }

    override fun getItemCount() = asteroidList.size


}