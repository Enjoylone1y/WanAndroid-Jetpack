package com.ezreal.wanandroid.utils

import android.util.Log

const val TAG =  "WanAndroid"

object Utils {
    fun err2Message(tips:String,code:Int,err:String) = "$tips:$err($code)"

    val LogE = fun (message:String) { Log.e(TAG,message) }

    val LogI = fun (message:String) { Log.i(TAG,message) }
}