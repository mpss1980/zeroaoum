package br.com.coupledev.listadehabitos.core

import br.com.coupledev.listadehabitos.collections.HabitItem

interface HabitRepository {
    fun fetchHabits(): List<HabitItem>

    fun addRandomHabit()

    fun toggleHabitCompleted(id: String)
}