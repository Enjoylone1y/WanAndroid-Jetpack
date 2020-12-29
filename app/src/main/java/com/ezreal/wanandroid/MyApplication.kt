package com.ezreal.wanandroid

import android.app.Application
import com.ezreal.wanandroid.utils.NetWorkHelper
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        NetWorkHelper.initContext(this)
    }
}