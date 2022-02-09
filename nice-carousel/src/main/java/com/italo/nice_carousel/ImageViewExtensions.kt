package com.italo.nice_carousel

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso

fun ImageView.load(url: String?) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun ImageView.load(@DrawableRes drawable: Int?) {
    drawable?.let {
        Picasso.get()
            .load(drawable)
            .into(this)
    }
}