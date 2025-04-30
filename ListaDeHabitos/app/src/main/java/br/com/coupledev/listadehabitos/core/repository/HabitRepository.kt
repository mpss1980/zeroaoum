package br.com.coupledev.listadehabitos.core.repository

import br.com.coupledev.listadehabitos.core.model.HabitDomain

interface HabitRepository {

    suspend fun fetchByDayOfWeek(dayOfWeek: Int): List<HabitDomain>

    suspend fun add(title: String, daysOfWeek: List<Int>)
}