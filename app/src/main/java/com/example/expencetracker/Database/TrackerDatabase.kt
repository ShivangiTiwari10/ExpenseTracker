package com.example.expencetracker.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income
import com.example.expencetracker.utilities.DATABASE_NAME


@Database(entities = [Expense::class, Income::class], version = 2)
abstract class TrackerDatabase : RoomDatabase() {

    abstract fun getexpenceDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: TrackerDatabase? = null

        fun getDataBase(context: Context): TrackerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(

                    context.applicationContext, TrackerDatabase::class.java,
                    DATABASE_NAME
                ) .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }
}