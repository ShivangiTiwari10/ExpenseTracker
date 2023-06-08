package com.example.expencetracker.Database

import androidx.room.Dao
import androidx.room.Insert
import com.example.expencetracker.model.ToDoModel

@Dao
interface ToDoDao {

    @Insert()
    suspend fun insertTask(todoModel: ToDoModel): Long
//
//    @Query("Select * from ToDoModel")
//    fun getTask(): LiveData<List<ToDoModel>>
//
//    @Query("Update ToDoModel where id=:uid")
//    fun finishTask(uid: Long)
//
//    @Query("Delete from TodoModel where id=:uid")
//    fun deleteTask(uid: Long)
}