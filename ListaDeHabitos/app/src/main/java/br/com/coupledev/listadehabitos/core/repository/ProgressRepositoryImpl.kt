package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.model.ProgressDomain
import java.util.Calendar
import java.util.UUID

object ProgressRepositoryImpl : ProgressRepository {

    private val progressListCache: MutableList<ProgressDomain> = mutableListOf()

    override suspend fun fetch(habitId: String, completedAt: Long): List<ProgressDomain> {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = completedAt
        return progressListCache.filter {
            it.habitId == habitId && it.dayOfWith == calendar.get(Calendar.DAY_OF_WEEK)
        }
    }

    override suspend fun add(habitId: String) {
        val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        val progress = ProgressDomain(
            id = UUID.randomUUID().toString(),
            habitId = habitId,
            dayOfWith = dayOfWeek
        )
        progressListCache.add(progress)
    }

    override suspend fun delete(habitId: String) {
        progressListCache.removeAll { it.id == habitId }
    }
}