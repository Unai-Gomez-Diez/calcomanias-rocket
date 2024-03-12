package com.example.calcomanias_rocket.feature.decals.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.calcomanias_rocket.R
import com.example.calcomanias_rocket.feature.decals.domain.Decal
import com.example.calcomanias_rocket.feature.decals.presentation.Adapter.DecalsViewHolder
import com.example.calcomanias_rocket.feature.decals.presentation.DecalsDiffUtil

class DecalsAdapter : androidx.recyclerview.widget.ListAdapter<Decal,DecalsViewHolder>(DecalsDiffUtil()){
    lateinit var onCLick: (decalId: String)-> Unit

    fun setEvent(onClick: (String) -> Unit){
        this.onCLick=onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DecalsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_decal, parent, false)
        return DecalsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DecalsViewHolder, position: Int) {
        holder.bind(dataSet[position], onCLick)
    }

    override fun getItemCount(): Int=dataSet.size

}