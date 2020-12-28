package com.ezreal.wanandroid.model.repository

import androidx.lifecycle.liveData
import com.ezreal.wanandroid.model.dao.HomeBannerDao
import com.ezreal.wanandroid.model.entities.Resource
import com.ezreal.wanandroid.model.network.RemoteApi
import com.ezreal.wanandroid.utils.Utils
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class HomeRepository @Inject constructor(private val bannerDao: HomeBannerDao,private val remoteApi: RemoteApi) {

    /**
     * 首页Banner
     */
    fun getHomeBanner() = liveData(Dispatchers.IO) {

        emit(Resource.loading())

        val resp = remoteApi.getHomeBanner()
        if (resp.errorCode == 0){
            bannerDao.deleteAll()
            bannerDao.insertAll(* resp.data.toTypedArray())
            emit(Resource.success(resp.data))
            return@liveData
        }

        val all = bannerDao.getAll()
        if (all.isNotEmpty()){
            emit(Resource.success(all))
            return@liveData
        }

        emit(Resource.error(Utils.err2Message("获取Banner失败",resp.errorCode,resp.errorMsg)))
    }


    /**
     * 热搜关键词
     */
//    fun getHotSearchWords() = RemoteApi.getHotSearchWord()

}