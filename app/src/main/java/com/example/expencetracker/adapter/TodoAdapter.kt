package com.example.expencetracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencetracker.R
import com.example.expencetracker.model.ToDoModel

class TodoAdapter(val list: List<ToDoModel>) : RecyclerView.Adapter<TodoAdapter.ToDoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(toDoModel: ToDoModel) {
            with(itemView) {
            val txtShowTitle = findViewById<TextView>(R.id.txtShowTitle)
            val txtShowTask = findViewById<TextView>(R.id.txtShowTask)
//            val txtShowCategory = findViewById<TextView>(R.id.txtShowCategory)

                txtShowTitle.text = toDoModel.title
                txtShowTask.text = toDoModel.description
            }

        }
    }

}


