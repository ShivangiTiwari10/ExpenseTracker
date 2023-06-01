package com.example.expencetracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.expencetracker.databinding.ActivityEditNotesBinding
import com.example.expencetracker.model.Person

class EditNotes : AppCompatActivity() {

    private lateinit var binding: ActivityEditNotesBinding

    private lateinit var person: Person

    private lateinit var old_note: Person
    private var isUpdate = false

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expencebtn.setOnClickListener {

            try {
                old_note = intent.getSerializableExtra("expense_tracker") as Person
                binding.textInputLayout.setText(old_note.text)
                binding.amountInputLayout.setText(old_note.amount.toString())
                binding.textDetail.setText(old_note.detail.toString())
                isUpdate = true
            } catch (e: Exception) {
                e.printStackTrace()
            }

            binding.imageCheck.setOnClickListener {

                val text = binding.textInputLayout.text.toString()
                val amount = binding.amountInputLayout.text.toString()
                val detail = binding.textDetail.text.toString()

                if (text.isNotEmpty() || amount.isNotEmpty() || detail.isNotEmpty()) {

                    person = if (isUpdate) {
                        Person(
                            old_note.id, old_note.text, old_note.amount, old_note.detail
                        )
                    } else {
                        Person(
                            null, text, amount, detail
                        )
                    }
                    val intent = Intent()
                    intent.putExtra("person", person)
                    setResult(RESULT_OK, intent)
                } else {
                    Toast.makeText(this@EditNotes, "Please enter some data", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

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
}