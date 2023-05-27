package com.example.expencetracker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.expencetracker.fragments.DailyFragment
import com.example.expencetracker.fragments.MonthlyFragment
import com.example.expencetracker.fragments.PenFragment
import com.example.expencetracker.fragments.YearlyFragment

class viewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> PenFragment()
            1 -> DailyFragment()
            2 -> MonthlyFragment()
            3 -> YearlyFragment()
            else -> throw IllegalArgumentException("Invalid tab position: $position")
        }
    }
}