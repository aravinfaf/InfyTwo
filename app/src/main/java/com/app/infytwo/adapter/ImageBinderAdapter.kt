package com.app.infytwo.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBinderAdapter {

    @JvmStatic
    @BindingAdapter("android:src")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.context).load(url).into(view)
        }
}