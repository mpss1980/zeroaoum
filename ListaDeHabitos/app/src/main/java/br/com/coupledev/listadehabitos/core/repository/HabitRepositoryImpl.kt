package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.model.HabitDomain
import java.util.UUID

object HabitRepositoryImpl : HabitRepository  {

    private val habitListCache: MutableList<HabitDomain> = mutableListOf()

    override suspend fun fetchAll(): List<HabitDomain> = habitListCache

    override suspend fun fetchByDayOfWeek(dayOfWeek: Int): List<HabitDomain> {
        return habitListCache.filter {
            it.daysOfWeek.contains(dayOfWeek)
        }
    }

    override suspend fun add(title: String, daysOfWeek: List<Int>) {
       val habit = HabitDomain(
           id = UUID.randomUUID().toString(),
           title = title,
           daysOfWeek = daysOfWeek
       )
        habitListCache.add(habit)
    }
}