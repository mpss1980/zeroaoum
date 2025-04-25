package br.com.coupledev.listadehabitos

import br.com.coupledev.listadehabitos.collections.HabitItem
import br.com.coupledev.listadehabitos.core.HabitRepository
import java.util.UUID

class TestHabitRepository : HabitRepository {
    val habitList = mutableListOf<HabitItem>()

    override fun fetchHabits() = habitList

    override fun toggleHabitCompleted(id: String) {
        val index = habitList.indexOfFirst { it.id == id }
        habitList[index] = habitList[index].copy(isCompleted = !habitList[index].isCompleted)
    }

    override fun addHabit(name: String, selectedHabitDays: List<Int>) {
        habitList.add(
            HabitItem(
                id = UUID.randomUUID().toString(),
                title = "Test Habit",
                isCompleted = false
            )
        )
    }
}