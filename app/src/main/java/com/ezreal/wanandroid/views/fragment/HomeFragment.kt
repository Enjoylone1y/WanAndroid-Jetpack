package com.ezreal.wanandroid.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ezreal.wanandroid.R
import com.ezreal.wanandroid.adapter.HomeBannerAdapter
import com.ezreal.wanandroid.databinding.FragmentHomeBinding
import com.ezreal.wanandroid.model.entities.HomeBannerInfo
import com.ezreal.wanandroid.model.entities.Status
import com.ezreal.wanandroid.utils.Utils
import com.ezreal.wanandroid.viewmodels.HomeViewModel

import com.youth.banner.indicator.RectangleIndicator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.bannerList.observe(viewLifecycleOwner) { res ->
            when (res.status) {
                Status.SUCCESS -> initBanner(res.data!!)

                Status.ERROR -> {
                    Utils.LogE(res.message!!)
                }

                Status.LOADING -> {
                    Utils.LogI("loading....")
                }
            }
        }


    }

    private fun initBanner(bannerList: List<HomeBannerInfo>) {
        binding.bannerHome
            .setAdapter(HomeBannerAdapter(bannerList))
            .addBannerLifecycleObserver(viewLifecycleOwner)
            .setIndicator(RectangleIndicator(requireContext()))
            .setOnBannerListener { banner, position ->
                //TODO
            }
    }



}