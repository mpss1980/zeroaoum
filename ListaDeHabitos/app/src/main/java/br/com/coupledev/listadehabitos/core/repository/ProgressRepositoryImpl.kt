package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.database.AppDatabase
import br.com.coupledev.listadehabitos.core.database.entity.Progress
import br.com.coupledev.listadehabitos.core.model.ProgressDomain
import java.util.Calendar
import java.util.UUID

class ProgressRepositoryImpl(appDatabase: AppDatabase) : ProgressRepository {

    private val dao = appDatabase.progressDao()

    override suspend fun fetch(habitId: String, completedAt: Long): List<ProgressDomain> {
        val calendar = Calendar.getInstance()
        return dao.fetchByHabitId(habitId, completedAt).map { progress ->
            calendar.timeInMillis = progress.completedAt
            ProgressDomain(
                id = progress.uuid,
                habitId = progress.habitId,
                dayOfWith = calendar.get(Calendar.DAY_OF_WEEK)
            )
        }
    }

    override suspend fun add(habitId: String) {
        val dayOfWeek = Calendar.getInstance()
        val progress = Progress(
            uuid = UUID.randomUUID().toString(),
            habitId = habitId,
            completedAt = dayOfWeek.timeInMillis
        )
        dao.insert(progress)
    }

    override suspend fun delete(habitId: String) {
        dao.delete(habitId)
    }
}