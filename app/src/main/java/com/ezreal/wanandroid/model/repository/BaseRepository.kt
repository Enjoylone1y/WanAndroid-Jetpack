package com.ezreal.wanandroid.model.repository

import com.ezreal.wanandroid.model.entities.Resource
import com.ezreal.wanandroid.model.network.BaseResp
import com.ezreal.wanandroid.utils.LogUtils
import com.ezreal.wanandroid.utils.NetWorkHelper
import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T> getResult(call: suspend () -> BaseResp<T>): Resource<T> {
        return try {
            if ( !NetWorkHelper.isNetworkAvailable()) {
                return Resource.error("请检查网络")
            }

            val resp = call()
            if (resp.errorCode == 0){
                Resource.success(resp.data!!)
            } else {
                Resource.error(resp.errorMsg)
            }
        }catch (e:Exception){
            Resource.error(e.message ?: e.toString())
        }
    }
}