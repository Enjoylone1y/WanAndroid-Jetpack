package com.ezreal.wanandroid.model.repository

import androidx.lifecycle.liveData
import com.ezreal.wanandroid.model.dao.HomeBannerDao
import com.ezreal.wanandroid.model.entities.Resource
import com.ezreal.wanandroid.model.entities.Status
import com.ezreal.wanandroid.model.network.RemoteApi
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val bannerDao: HomeBannerDao,
    private val remoteApi: RemoteApi
) : BaseRepository() {

    /**
     * 首页Banner
     */
    fun getHomeBanner() = liveData(Dispatchers.IO) {
        emit(Resource.loading())

        // 先从数据库取数据
        val all = bannerDao.getAll()

        if (all.isNotEmpty()) {
            emit(Resource.success(all))
        }

        val  resource = getResult { remoteApi.getHomeBanner() }
        emit(resource)

        // 从网络获取，如果取到，则存入数据库
        if (resource.status == Status.SUCCESS){
            bannerDao.insertAll(*resource.data!!.toTypedArray())
        }
    }


    /**
     * 热搜关键词
     */
//    fun getHotSearchWords() = RemoteApi.getHotSearchWord()

}