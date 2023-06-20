package com.example.expencetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Expense

// Structure of list itenm
class ExpenseAdapter(context: Context) : ArrayAdapter<Expense>(
    context, R.layout.edit_text_layout
) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View    {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.edit_text_layout, parent, false)
        }

        val expense = getItem(position)
        // Set the data to the views in your custom layout
        // Example:
        val expenseText = itemView?.findViewById<TextView>(R.id.text)
        val expenseAmount = itemView?.findViewById<TextView>(R.id.tv_Amount)

        val expenseDetail = itemView?.findViewById<TextView>(R.id.tv_Detail)

        if (expenseText != null) {
            expenseText.text = expense?.text
        }
        if (expenseAmount != null) {
            expenseAmount.text = expense?.amount.toString()
        }

        if (expenseDetail != null) {
            expenseDetail.text = expense?.detail
        }

        return itemView!!
    }
    interface ExpenseClicklistner {


        fun onLongItemClicked(expense: Expense)
    }


}