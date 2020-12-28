package com.ezreal.wanandroid.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ezreal.wanandroid.R
import com.ezreal.wanandroid.databinding.FragmentProjectsBinding


class ProjectsFragment : Fragment() {

    private lateinit var activeBinding: FragmentProjectsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_projects,container,false)
        return activeBinding.root
    }
}