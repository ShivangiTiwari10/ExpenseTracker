package com.example.expencetracker

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.expencetracker.databinding.ActivityEditNotesBinding
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income

class EditNotes : AppCompatActivity() {

    private lateinit var binding: ActivityEditNotesBinding

    private var isExpenseButtonActive = true

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.expencebtn.setOnClickListener {
            isExpenseButtonActive = true
            showItem()

        }

        binding.incomebtn.setOnClickListener {

            isExpenseButtonActive = false
            showItem()

        }

    }

    private fun showItem() {

        binding.imageCheck.setOnClickListener {

            val text = binding.textInputLayout.text.toString()
            val amount = binding.amountInputLayout.text.toString().toDoubleOrNull()
            val detail = binding.textDetail.text.toString()
            val date = binding.date.text.toString()

            if (text.isNotEmpty() && amount != null && detail.isNotEmpty()) {

                if (isExpenseButtonActive) {
                    val expense = Expense(null, text, amount, detail)
                    val intent = Intent()

                    intent.putExtra("expense", expense)
                    setResult(Activity.RESULT_OK, intent)
                } else {
                    val income = Income(null, text, amount, detail )

                    val intent = Intent()
                    intent.putExtra("income", income)
                    setResult(Activity.RESULT_OK, intent)
                }
                finish()

            } else {
                Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
            }


        }
        val view: View? = this.currentFocus
        if (view != null) {
            // on below line we are creating a variable
            // for input manager and initializing it.
            val inputMethodManager =
                getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

            // on below line hiding our keyboard.

            inputMethodManager.hideSoftInputFromWindow(view.applicationWindowToken, 0)

            // displaying toast message on below line.
            Toast.makeText(this, "Key board hidden", Toast.LENGTH_SHORT).show()
        }

    }
}