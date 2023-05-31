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

    private val repository: TrackerRepository

    val allExpense: LiveData<List<Person>>

    init {
        val dao = TrackerDatabase.getDataBase(application).getexpenceDao()
        repository = TrackerRepository(dao)
        allExpense = repository.allExpense
    }

    fun deleteExpence(expense: Person) = viewModelScope.launch(Dispatchers.IO) {

        repository.delete(expense)
    }

    fun insert(expense: Person) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(expense)
    }

    fun update(expense: Person) = viewModelScope.launch (Dispatchers.IO){
        repository.update(expense)
    }

}