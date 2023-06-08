package com.example.expencetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Expense

class MonthlyExpenserAdapter(context: Context) :
    ArrayAdapter<Expense>(context, R.layout.monthaly_item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.monthaly_item, parent, false)
        }

        val expense = getItem(position)

        val expenseText = itemView?.findViewById<TextView>(R.id.Texts)
        val expenseAmount = itemView?.findViewById<TextView>(R.id.amount)


        if (expenseText != null) {
            expenseText.text = expense?.text
        }
        if (expenseAmount != null){

            expenseAmount.text = expense?.amount.toString()
        }

            return itemView!!
    }


}