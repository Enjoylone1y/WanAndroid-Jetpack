package com.ezreal.wanandroid.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object ViewBindAdapter {

    @BindingAdapter("imgByResId")
    @JvmStatic fun setImageByResId(imageView: ImageView,srcId:Int){
        imageView.setImageResource(srcId)
    }

}