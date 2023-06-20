package com.example.expencetracker.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.expencetracker.R
import com.example.expencetracker.model.Income
import java.text.SimpleDateFormat
import java.util.*

class MonthalyAdapter(context: Context) : ArrayAdapter<Income>(
    context, R.layout.income_card
) {


    @SuppressLint("SimpleDateFormat")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.income_card, parent, false)
        }

        val income = getItem(position)

        val incomeText = itemView?.findViewById<TextView>(R.id.texts)
        val incomeAmount = itemView?.findViewById<TextView>(R.id.amounts)
        val incomeDate = itemView?.findViewById<TextView>(R.id.Datess)

        if (incomeText != null) {
            incomeText.text = income?.text
        }
        if (incomeAmount != null) {
            incomeAmount.text = income?.amount.toString()
            Log.d("Amount", income?.amount.toString())
        }

        val date= Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = dateFormat.format(date)


        if (incomeDate != null) {
            incomeDate.text = formattedDate
        }
        return itemView!!
    }
}



