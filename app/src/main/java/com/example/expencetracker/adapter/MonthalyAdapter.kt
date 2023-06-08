package com.example.expencetracker.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Income

class MonthalyAdapter(context: Context) : ArrayAdapter<Income>(
    context, R.layout.monthaly_item
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.monthaly_item, parent, false)
        }

        val income = getItem(position)

        val incomeText = itemView?.findViewById<TextView>(R.id.Texts)
        val incomeAmount = itemView?.findViewById<TextView>(R.id.amount)

        if (incomeText != null) {
            incomeText.text = income?.text
        }
        if (incomeAmount != null) {
            incomeAmount.text = income?.amount.toString()
            Log.d("Amount", income?.amount.toString())
        }

        return itemView!!

    }

}