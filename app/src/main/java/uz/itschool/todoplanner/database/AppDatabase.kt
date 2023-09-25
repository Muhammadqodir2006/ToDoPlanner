package uz.itschool.todoplanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.itschool.todoplanner.database.dao.TaskDao
import uz.itschool.todoplanner.database.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                    .allowMainThreadQueries().build()
            }
            return instance!!
        }
    }

    abstract fun getTaskDao(): TaskDao

}