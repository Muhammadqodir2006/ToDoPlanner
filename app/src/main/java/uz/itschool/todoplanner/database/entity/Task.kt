package uz.itschool.todoplanner.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var state : Int = 0,
    var task : String,
    var subtasks : String,
    var priority : Boolean,
    var category : Boolean,
):Serializable