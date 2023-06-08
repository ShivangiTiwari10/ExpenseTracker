package com.example.expencetracker.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expencetracker.ToDoactivity
import com.example.expencetracker.databinding.FragmentPenBinding


class PenFragment : Fragment() {


    private lateinit var binding: FragmentPenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPenBinding.inflate(layoutInflater)



        binding.fb.setOnClickListener {

            val intent = Intent(requireContext(), ToDoactivity::class.java)
            startActivity(intent)

        }


        return (binding.root)
    }
}