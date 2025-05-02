package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.database.dao.HabitDao
import br.com.coupledev.listadehabitos.core.database.entity.Habit
import br.com.coupledev.listadehabitos.core.model.HabitDomain
import java.util.UUID
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val dao: HabitDao
) : HabitRepository {

    override suspend fun fetchByDayOfWeek(dayOfWeek: Int): List<HabitDomain> {
        return dao.fetchByDayOfWeek(dayOfWeek).map {
            HabitDomain(
                id = it.id,
                title = it.title,
                daysOfWeek = it.daysOfWeek
            )
        }
    }

    override suspend fun add(title: String, daysOfWeek: List<Int>) {
        val habit = Habit(
            id = UUID.randomUUID().toString(),
            title = title,
            daysOfWeek = daysOfWeek
        )
        dao.insert(habit = habit)
    }
}