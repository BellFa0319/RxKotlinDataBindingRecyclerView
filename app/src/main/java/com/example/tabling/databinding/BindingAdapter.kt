package com.example.tabling.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView : ImageView , url : String){
        Glide.with(imageView.context).load(url).into(imageView)
    }
}