package com.example.expencetracker.Database

import androidx.lifecycle.LiveData
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income

class TrackerRepository(private val expencedao: ExpenseDao) {


    val allExpense: LiveData<List<Expense>> = expencedao.getAllExpence()

    val allIncome: LiveData<List<Income>> = expencedao.getAllIncome()

    suspend fun addExpense(expence: Expense) {
        expencedao.insert(expence)

    }
    suspend fun deleteExpense(expense: Expense) {
        expencedao.delete(expense)
    }

    suspend fun deleteIncome(expense: Income) {
        expencedao.delete(expense)
    }

    suspend fun addIncome(income: Income) {
        expencedao.insertIncome(income)

    }






}