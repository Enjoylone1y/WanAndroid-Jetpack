package com.ezreal.wanandroid.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ezreal.wanandroid.model.repository.HomeRepository


class HomeViewModel @ViewModelInject
constructor(private val repository: HomeRepository,
            @Assisted savedStateHandle: SavedStateHandle) : ViewModel() {
    val bannerList = repository.getHomeBanner()

}