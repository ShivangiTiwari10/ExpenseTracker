package com.example.expencetracker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expencetracker.databinding.ActivityToDoactivityBinding
import com.example.expencetracker.model.ToDoModel
import java.util.*

const val DB_NAME = "todo.db"

class ToDoactivity : AppCompatActivity() {

    val list = arrayListOf<ToDoModel>()

    private lateinit var binding: ActivityToDoactivityBinding

    private lateinit var myCalendar: Calendar
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener


    private var finalDate = 0L

    val db by lazy {
        AppDatabase.getDatabase(this)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToDoactivityBinding.inflate(layoutInflater)


            setContentView(binding.root)
    }
}