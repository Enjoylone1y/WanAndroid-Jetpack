package com.ezreal.wanandroid.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ezreal.wanandroid.R
import com.ezreal.wanandroid.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    private lateinit var musicBinding: FragmentNavigationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        musicBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_navigation,container,false)

        return musicBinding.root
    }
}