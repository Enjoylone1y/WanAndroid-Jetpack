package com.ezreal.wanandroid.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ezreal.wanandroid.model.entities.HomeBannerInfo

@Dao
interface HomeBannerDao {

    @Query("SELECT * FROM HomeBanner")
    fun getAll():List<HomeBannerInfo>

    @Insert
    suspend fun insertAll(vararg homeBanner: HomeBannerInfo)

    @Delete
    fun deleteItem(bannerInfo: HomeBannerInfo)

    @Query("DELETE FROM HomeBanner")
    fun deleteAll()
}