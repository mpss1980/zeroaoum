package br.com.coupledev.listadehabitos.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.coupledev.listadehabitos.core.database.DaysOfWeekConverter

@Entity(tableName = "habit")
data class Habit(
    @PrimaryKey val id: String,
    val title: String,
    @TypeConverters(DaysOfWeekConverter::class)
    val daysOfWeek: List<Int>
)
