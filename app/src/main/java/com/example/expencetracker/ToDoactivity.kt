package com.example.expencetracker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.expencetracker.databinding.ActivityToDoactivityBinding
import com.example.expencetracker.model.ToDoModel
import kotlinx.coroutines.*
import java.util.*

const val DB_NAME = "todo.db"

class ToDoactivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityToDoactivityBinding

    val db by lazy {
        AppDatabase.getDatabase(this)
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToDoactivityBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        setContentView(binding.root)
        binding.saveBtn.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.saveBtn -> {
                saveToDo()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun saveToDo() {

        val title = binding.titleInpLay.editText?.text.toString()
        val description = binding.taskInpLay.editText?.text.toString()

        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    return@withContext db.todoDao().insertTask(
                        ToDoModel(
                            title,
                            description

                        )

                    )
                }
                finish()
            }
        }

    }
}