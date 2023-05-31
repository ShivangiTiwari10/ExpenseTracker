package com.example.expencetracker.Database

import androidx.lifecycle.LiveData
import com.example.expencetracker.model.Person

class TrackerRepository(private val expencedao: ExpenseDao) {

    val allExpense: LiveData<List<Person>> = expencedao.getAllExpence()

    suspend fun insert(expence: Person) {
        expencedao.insert(expence)

    }


    suspend fun delete(expence: Person) {
        expencedao.delete(expence)
    }

    suspend fun update(expence: Person) {
        expencedao.update(expence.id,expence.text,expence.detail,expence.amount)
    }


}