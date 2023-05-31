package com.example.expencetracker.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.expencetracker.model.Person


@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Person)
    @Delete
    suspend fun delete(expense: Person)

    @Query("SELECT * from expense_tracker ORDER BY id ASC")
    fun getAllExpence(): LiveData<List<Person>>


    @Query("UPDATE expense_tracker  SET  text=:text,amount=:amount,detail =:detail WHERE id =:id")
    suspend fun update(id: Int?, text: String?, detail: String?, amount: String?)



}