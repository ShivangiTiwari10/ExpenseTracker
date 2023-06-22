package com.example.expencetracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "income_tracker")
data class Income(

    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name ="text") val text:String?,
    @ColumnInfo(name="amount") val amount:Double?,
    @ColumnInfo(name="detail") val detail:String?,

): java.io.Serializable
