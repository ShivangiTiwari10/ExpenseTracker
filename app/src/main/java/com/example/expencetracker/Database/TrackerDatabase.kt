package com.example.expencetracker.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expencetracker.model.Person
import com.example.expencetracker.utilities.DATABASE_NAME


@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class TrackerDatabase : RoomDatabase() {

    abstract fun getexpenceDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: TrackerDatabase? = null

        fun getDataBase(context: Context): TrackerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(

                    context.applicationContext, TrackerDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}