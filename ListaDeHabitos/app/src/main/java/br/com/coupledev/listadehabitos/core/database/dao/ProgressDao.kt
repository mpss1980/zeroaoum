package br.com.coupledev.listadehabitos.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.coupledev.listadehabitos.core.database.entity.Progress

@Dao
interface ProgressDao {
    @Query(
        """
            SELECT * FROM progress
            WHERE habitId LIKE :habitId
            AND DATE(completedAt/1000, 'unixepoch') = DATE(:completedAt/1000, 'unixepoch')
        """
    )
    suspend fun fetchByHabitId(habitId: String, completedAt: Long): List<Progress>

    @Insert
    suspend fun insert(progress: Progress)

    @Query("DELETE FROM progress WHERE uuid = :id")
    suspend fun delete(id: String)
}