package com.ezreal.wanandroid.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ezreal.wanandroid.model.entities.HomeBannerInfo

@Dao
interface HomeBannerDao {

    @Query("SELECT * FROM HomeBanner")
    suspend fun getAll():List<HomeBannerInfo>


    @Query("DELETE FROM HomeBanner")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg homeBanner: HomeBannerInfo)

    @Delete
    suspend fun deleteItem(bannerInfo: HomeBannerInfo)
}