package uz.itschool.todoplanner.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.itschool.todoplanner.database.entity.Task

@Dao
interface TaskDao {
    @Query("select * from tasks where state = 0")
    fun getUndone(): List<Task>

    @Query("select * from tasks where state = 1")
    fun getTasks(): List<Task>

    @Insert
    fun addTask(newTask: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)
}