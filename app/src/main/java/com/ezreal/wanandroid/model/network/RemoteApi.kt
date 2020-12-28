package com.ezreal.wanandroid.model.network

import com.ezreal.wanandroid.model.entities.HomeBannerInfo
import com.ezreal.wanandroid.model.entities.HotSearchWord
import retrofit2.http.GET

data class BaseResp <T>(val errorCode:Int, val errorMsg:String,val data:T)

interface RemoteApi {

    @GET("banner/json")
    suspend fun getHomeBanner(): BaseResp<List<HomeBannerInfo>>

    @GET("hotkey/json")
    suspend fun getHotSearchWord(): BaseResp<List<HotSearchWord>>

}

