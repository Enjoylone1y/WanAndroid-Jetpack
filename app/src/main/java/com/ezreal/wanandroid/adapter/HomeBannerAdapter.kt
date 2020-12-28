package com.ezreal.wanandroid.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ezreal.wanandroid.model.entities.HomeBannerInfo
import com.youth.banner.adapter.BannerAdapter

class HomeBannerViewHolder(imageView: ImageView): RecyclerView.ViewHolder(imageView)


class HomeBannerAdapter(dataList:List<HomeBannerInfo>):
    BannerAdapter<HomeBannerInfo, HomeBannerViewHolder>(dataList) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): HomeBannerViewHolder {
        val imageView = ImageView(parent?.context)
        imageView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return HomeBannerViewHolder(imageView)
    }


    override fun onBindView(
        holder: HomeBannerViewHolder?, data: HomeBannerInfo?,
        position: Int, size: Int) {
        Glide.with(holder?.itemView?.context!!).load(data?.imagePath)
           .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
           .into(holder.itemView as ImageView)
    }

}