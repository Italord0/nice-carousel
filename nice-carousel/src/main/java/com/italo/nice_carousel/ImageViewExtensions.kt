package com.italo.nice_carousel

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadFromUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}