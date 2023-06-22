package com.example.expencetracker.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expencetracker.AppDatabase
import com.example.expencetracker.ToDoactivity
import com.example.expencetracker.adapter.TodoAdapter
import com.example.expencetracker.databinding.FragmentPenBinding
import com.example.expencetracker.model.ToDoModel


class PenFragment : Fragment() {


    private lateinit var binding: FragmentPenBinding
    val list = arrayListOf<ToDoModel>()
    var adapter = TodoAdapter(list)

    val db by lazy {
        AppDatabase.getDatabase(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPenBinding.inflate(layoutInflater)


        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@PenFragment.adapter
        }
        db.todoDao().getTask().observe(requireActivity()) {
            if (!it.isNullOrEmpty()) {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            } else {
                list.clear()
                adapter.notifyDataSetChanged()
            }
        }
        binding.fb.setOnClickListener {

            val intent = Intent(requireContext(), ToDoactivity::class.java)
            startActivity(intent)

        }


        return (binding.root)
    }
}