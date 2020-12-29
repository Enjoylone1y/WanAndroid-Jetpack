package com.ezreal.wanandroid.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import javax.inject.Inject

const val TAG =  "WanAndroid"

object LogUtils  {

    val LogE = fun (message:String) { Log.e(TAG,message) }

    val LogI = fun (message:String) { Log.i(TAG,message) }
}


object NetWorkHelper {
    private lateinit var context: Context

    fun initContext(context: Context){
        this.context = context
    }

    fun isNetworkAvailable(): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            val network = connectivityManager.activeNetwork
            val cap =  connectivityManager.getNetworkCapabilities(network)
            cap != null && cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } else {
            val activeNetworkInfo =connectivityManager.activeNetworkInfo
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

}