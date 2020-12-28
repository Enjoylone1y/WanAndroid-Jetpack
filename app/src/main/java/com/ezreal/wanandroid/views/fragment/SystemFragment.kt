package com.ezreal.wanandroid.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ezreal.wanandroid.R
import com.ezreal.wanandroid.databinding.FragmentSystemBinding


class SystemFragment : Fragment() {

    private lateinit var mineBinding: FragmentSystemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mineBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_system,container,false)
        return mineBinding.root
    }
}