package com.ezreal.wanandroid.model.network

import com.ezreal.wanandroid.model.entities.HomeBannerInfo
import com.ezreal.wanandroid.model.entities.HotSearchWord
import retrofit2.http.GET
import retrofit2.http.Path

data class BaseResp <T>(val errorCode:Int = -1, val errorMsg:String = "",val data:T? = null)

interface RemoteApi {

    @GET("banner/json")
    suspend fun getHomeBanner(): BaseResp<List<HomeBannerInfo>>

    @GET("hotkey/json")
    suspend fun getHotSearchWord(): BaseResp<List<HotSearchWord>>

    @GET("article/list/{page}/json")
    suspend fun getHomeArticle(@Path("page") page:Int)
}

