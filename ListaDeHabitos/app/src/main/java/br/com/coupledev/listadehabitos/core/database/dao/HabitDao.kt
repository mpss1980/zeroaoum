package br.com.coupledev.listadehabitos.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.coupledev.listadehabitos.core.database.entity.Habit

@Dao
interface HabitDao {
    @Query("SELECT * FROM habit WHERE daysOfWeek LIKE '%'||:dayOfWeek||'%'")
    suspend fun fetchByDayOfWeek(dayOfWeek: Int): List<Habit>

    @Insert
    suspend fun insert(habit: Habit)
}