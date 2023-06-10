package com.example.expencetracker.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Expense
import java.text.SimpleDateFormat
import java.util.*

class MonthlyExpenserAdapter(context: Context) :
    ArrayAdapter<Expense>(context, R.layout.income_card) {

    @SuppressLint("SimpleDateFormat")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.income_card, parent, false)
        }

        val expense = getItem(position)

        val expenseText = itemView?.findViewById<TextView>(R.id.texts)
        val expenseAmount = itemView?.findViewById<TextView>(R.id.amounts)
        val expenseDate = itemView?.findViewById<TextView>(R.id.Datess)


        if (expenseText != null) {
            expenseText.text = expense?.text
        }
        if (expenseAmount != null) {

            expenseAmount.text = expense?.amount.toString()
        }


        val date= Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = dateFormat.format(date)


        if (expenseDate != null) {
            expenseDate.text = formattedDate
        }

        return itemView!!
    }


}