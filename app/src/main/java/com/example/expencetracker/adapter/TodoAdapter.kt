package com.example.expencetracker.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expencetracker.model.ToDoModel
import java.text.SimpleDateFormat
import java.util.*

class TodoAdapter(val list: List<ToDoModel>) : RecyclerView.Adapter<TodoAdapter.ToDoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
//        holder.(list[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        private fun updateDate(time: Long) {
            //Mon, 5 Jan 2020

            val sdf = SimpleDateFormat("EEE, d MMM yyyy")
//            itemView.findViewById<TextView>().text = sdf.format(Date(time))

        }

    }

}


