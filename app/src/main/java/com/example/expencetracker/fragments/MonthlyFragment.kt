package com.example.expencetracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expencetracker.databinding.FragmentMonthlyBinding


class MonthlyFragment : Fragment() {

    private lateinit var binding: FragmentMonthlyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentMonthlyBinding.inflate(layoutInflater)
        return binding.root
    }
}