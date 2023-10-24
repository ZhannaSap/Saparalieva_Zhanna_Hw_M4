package com.example.saparalieva_zhanna_hw_m4.utils

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun  ImageView.loadImage(url: String?){
    Glide.with(this).load(url).into(this)
}