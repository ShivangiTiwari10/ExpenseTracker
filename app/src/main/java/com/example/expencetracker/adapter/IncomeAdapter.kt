package com.example.expencetracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Income

class IncomeAdapter(context: Context) : ArrayAdapter<Income>(context, R.layout.edit_text_layout) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.edit_text_layout, parent, false)
        }


        val income = getItem(position)

        val incomeText = itemView?.findViewById<TextView>(R.id.text)
        val inComeAmount = itemView?.findViewById<TextView>(R.id.tv_Amount)
        val incomeDetail = itemView?.findViewById<TextView>(R.id.tv_Detail)

        if (incomeText != null) {
            incomeText.text = income?.text
        }

        if (inComeAmount != null) {
            if (income != null) {
                inComeAmount.text = income.amount.toString()
            }
        }
        if (incomeDetail != null) {

            if (income != null) {
                incomeDetail.text = income.detail
            }
        }
        return itemView!!
    }
}