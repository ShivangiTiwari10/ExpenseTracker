package com.example.expencetracker.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.expencetracker.model.Person
import com.example.expencetracker.R

class DailyfragmentAdapter(private val context: Context, val listner: NotesClickedListener) :
    RecyclerView.Adapter<DailyfragmentAdapter.RecyclerViewholder>() {

    private val expenserList = ArrayList<Person>()
    private val fullList =
        ArrayList<Person>()


    interface NotesClickedListener {
        fun onItemClicked(note: Person)
        fun onLongItemClicked(note: Person, cardView: CardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewholder {

        return RecyclerViewholder(
            LayoutInflater.from(context).inflate(R.layout.edit_text_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewholder, position: Int) {

        val currentNote = expenserList[position]

        holder.texts.text = currentNote.text
        holder.texts.isSelected = true
        holder.amount.text = currentNote.amount.toString()
        holder.amount.isSelected = true
        holder.detail.text = currentNote.detail

        holder.expeceCard.setOnClickListener {

            listner.onItemClicked(expenserList[holder.adapterPosition])
        }

        holder.expeceCard.setOnLongClickListener {
            listner.onLongItemClicked(expenserList[holder.adapterPosition], holder.expeceCard)
            true
        }

    }

    override fun getItemCount(): Int {
        return expenserList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Person>) {


        fullList.clear()
        fullList.addAll(newList)

        expenserList.clear()
        expenserList.addAll(fullList)
        notifyDataSetChanged()
    }

    class RecyclerViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val expeceCard: CardView = itemView.findViewById(R.id.card_layout)
        val texts: TextView = itemView.findViewById(R.id.text)
        val amount: TextView = itemView.findViewById(R.id.tv_Amount)
        val detail: TextView = itemView.findViewById(R.id.tv_Detail)

    }
}