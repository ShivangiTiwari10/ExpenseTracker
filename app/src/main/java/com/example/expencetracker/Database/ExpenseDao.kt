package com.example.expencetracker.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income


@Dao
interface ExpenseDao {

    @Query("SELECT * from expense_tracker")
    fun getAllExpence(): LiveData<List<Expense>>

    @Query("SELECT * from income_tracker")
    fun getAllIncome(): LiveData<List<Income>>

//    insertMethod for expense
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expense_tracker")
    fun getExpensesForDate(): LiveData<List<Expense>>


    //    insertMethod for income
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIncome(income: Income)

    @Query("SELECT SUM(amount) FROM expense_tracker")
    fun getTotalExpense(): LiveData<Double>

    @Query("SELECT SUM(amount) FROM income_tracker")
    fun getTotalIncome(): LiveData<Double>

    @Delete
    suspend fun delete(expense: Expense)
    @Delete
    suspend fun delete(income: Income)


}