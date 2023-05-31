package com.example.expencetracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_tracker")
data class Person(

    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name ="text")val text:String?,
    @ColumnInfo(name="amount") val amount:String?,
    @ColumnInfo(name="detail") val detail:String?

): java.io.Serializable


