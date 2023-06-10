package com.example.expencetracker.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.expencetracker.Database.TrackerDatabase
import com.example.expencetracker.Database.TrackerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class trackerViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: TrackerRepository

    val allExpense: LiveData<List<Expense>>
    val getExpensesForDate :LiveData<List<Expense>>

    val allInCome: LiveData<List<Income>>

    init {
        val dao = TrackerDatabase.getDataBase(application).getexpenceDao()
        repository = TrackerRepository(dao)
        getExpensesForDate= repository.allExpense
    }

    init {
        val dao = TrackerDatabase.getDataBase(application).getexpenceDao()
        repository = TrackerRepository(dao)
        allExpense = repository.allExpense
    }

    init {
        val dao = TrackerDatabase.getDataBase(application).getexpenceDao()
        repository = TrackerRepository(dao)
        allInCome = repository.allIncome

    }



    fun addExpense(expense: Expense) = viewModelScope.launch(Dispatchers.IO) {
        repository.addExpense(expense)
    }


    fun addIncome(income: Income) = viewModelScope.launch(Dispatchers.IO) {
        repository.addIncome(income)
    }

    fun getExpensesForDate()= viewModelScope.launch(Dispatchers.IO) {
        repository.getExpensesForDate()
    }

}