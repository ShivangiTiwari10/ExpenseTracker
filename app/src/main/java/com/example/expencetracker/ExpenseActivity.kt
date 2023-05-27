package com.example.expencetracker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expencetracker.databinding.ActivityExpenseBinding
import com.google.android.material.tabs.TabLayoutMediator

class ExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenseBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = viewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        val tabTitles = listOf("Daily", "Monthly", "Yearly")

            TabLayoutMediator(binding.tablayot, binding.viewPager) { tab, position ->
                tab.text = tabTitles[position]
            }.attach()
    }
}