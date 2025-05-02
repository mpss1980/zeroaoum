package br.com.coupledev.listadehabitos

import br.com.coupledev.listadehabitos.collections.model.HabitItem
import br.com.coupledev.listadehabitos.core.model.HabitDomain
import br.com.coupledev.listadehabitos.core.repository.HabitRepository

class TestHabitRepository : HabitRepository {
    val habitList = mutableListOf<HabitItem>()

//    override fun fetchHabits() = habitList
//
//    override fun toggleHabitCompleted(id: String) {
//        val index = habitList.indexOfFirst { it.id == id }
//        habitList[index] = habitList[index].copy(isCompleted = !habitList[index].isCompleted)
//    }
//
//    override fun addHabit(name: String, selectedHabitDays: List<Int>) {
//        habitList.add(
//            HabitItem(
//                id = UUID.randomUUID().toString(),
//                title = "Test Habit",
//                isCompleted = false
//            )
//        )
//    }

    override suspend fun fetchByDayOfWeek(dayOfWeek: Int): List<HabitDomain> {
        TODO("Not yet implemented")
    }

    override suspend fun add(title: String, daysOfWeek: List<Int>) {
        TODO("Not yet implemented")
    }
}