package br.com.coupledev.listadehabitos.collections.domain

import br.com.coupledev.listadehabitos.collections.model.HabitItem
import br.com.coupledev.listadehabitos.core.repository.HabitRepository
import br.com.coupledev.listadehabitos.core.repository.ProgressRepository
import java.util.Calendar

class GetHabitForTodayUseCaseImpl(
    private val habitRepository: HabitRepository,
    private val progressRepository: ProgressRepository
) : GetHabitForTodayUseCase {
    override suspend fun invoke(): List<HabitItem> {
        val today = Calendar.getInstance()
        val dayOfWeek = today.get(Calendar.DAY_OF_WEEK)

        return habitRepository
            .fetchByDayOfWeek(dayOfWeek)
            .map { habit ->
                val progress = progressRepository.fetch(habit.id, today.timeInMillis)
                val isCompletedToday = progress.isNotEmpty()
                HabitItem(
                    id = habit.id,
                    title = habit.title,
                    isCompleted = isCompletedToday
                )
            }
    }
}