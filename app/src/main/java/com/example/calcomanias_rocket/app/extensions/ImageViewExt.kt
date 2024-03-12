package com.example.calcomanias_rocket.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadurl(image: String) {
    Glide.with(this).load(image).into(this)
}