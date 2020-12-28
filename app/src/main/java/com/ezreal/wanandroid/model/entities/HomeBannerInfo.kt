package com.ezreal.wanandroid.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "HomeBanner")
data class HomeBannerInfo(
    @PrimaryKey
    val id: Int,

    val imagePath: String,
    val desc: String,
    val isVisible: Int,
    val type: Int,
    val order:Int,
    val title: String,
    val url: String,
)
