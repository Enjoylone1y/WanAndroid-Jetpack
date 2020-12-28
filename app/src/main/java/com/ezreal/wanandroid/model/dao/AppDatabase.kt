package com.ezreal.wanandroid.model.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ezreal.wanandroid.model.entities.HomeBannerInfo


@Database(entities = arrayOf(HomeBannerInfo::class), version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun bannerDao() : HomeBannerDao

    companion object {
        @Volatile private var instance:AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(context: Context):AppDatabase =
            Room.databaseBuilder(context,AppDatabase::class.java,"Root")
                .fallbackToDestructiveMigration()
                .build()
    }
}