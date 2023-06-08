package com.example.expencetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoModel(
    @PrimaryKey(autoGenerate = true)
    var date: Long,
)
