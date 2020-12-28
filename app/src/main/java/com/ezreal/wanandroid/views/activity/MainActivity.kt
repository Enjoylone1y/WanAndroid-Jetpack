package com.ezreal.wanandroid.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ezreal.wanandroid.R
import com.ezreal.wanandroid.databinding.ActivityMainBinding
import com.ezreal.wanandroid.views.fragment.ProjectsFragment
import com.ezreal.wanandroid.views.fragment.NavigationFragment
import com.ezreal.wanandroid.views.fragment.HomeFragment
import com.ezreal.wanandroid.views.fragment.SystemFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

private const val FRAGMENT_COUNT = 4

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.viewPage.adapter = MainPageAdapter(this)

        mainBinding.viewPage.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mainBinding.navigationView.menu.getItem(position).isChecked = true
            }
        })

        mainBinding.navigationView.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.item_home -> mainBinding.viewPage.setCurrentItem(0,false)

            R.id.item_system -> mainBinding.viewPage.setCurrentItem(1,false)

            R.id.item_navigation -> mainBinding.viewPage.setCurrentItem(2,false)

            R.id.item_projects -> mainBinding.viewPage.setCurrentItem(3,false)
        }
        return true
    }

    private fun getFragmentByPosition(position:Int):Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> NavigationFragment()
            2 -> SystemFragment()
            3 -> ProjectsFragment()
            else -> HomeFragment()
        }
    }

    private inner class MainPageAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
        override fun getItemCount(): Int = FRAGMENT_COUNT
        override fun createFragment(position: Int) = getFragmentByPosition(position)
    }
}

