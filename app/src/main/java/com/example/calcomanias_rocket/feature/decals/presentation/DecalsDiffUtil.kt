package com.example.calcomanias_rocket.feature.decals.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.calcomanias_rocket.feature.decals.domain.Decal

class DecalsDiffUtil: DiffUtil.ItemCallback<Decal>() {
    override fun areItemsTheSame(oldItem: Decal, newItem: Decal): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Decal, newItem: Decal): Boolean {
        return oldItem == newItem
    }
}