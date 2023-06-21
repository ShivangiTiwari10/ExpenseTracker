package com.example.expencetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoModel(
    var title: String,
    var description: String,
    var isFinished: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

)
