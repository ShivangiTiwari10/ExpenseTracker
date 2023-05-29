package com.example.expencetracker.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expencetracker.R
import com.example.expencetracker.databinding.FragmentDailyBinding


class DailyFragment : Fragment() {

    private lateinit var binding: FragmentDailyBinding

    private lateinit var dialog: AlertDialog

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

        binding = FragmentDailyBinding.inflate(layoutInflater)

        dialog = AlertDialog.Builder(requireContext()).setView(R.layout.edit_text_layout)
            .setCancelable(false)
            .create()
        dialog.window?.setGravity(Gravity.BOTTOM)

        binding.floatingActionButton.setOnClickListener {
            dialog.show()
        }
        return (binding.root)

    }


}