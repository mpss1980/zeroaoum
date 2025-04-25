package br.com.coupledev.listadehabitos.dummy

import br.com.coupledev.listadehabitos.collections.HabitItem
import br.com.coupledev.listadehabitos.core.HabitRepository
import java.util.UUID

object MockHabits : HabitRepository {

    private val habitList: MutableList<HabitItem> = mutableListOf()

    override fun fetchHabits(): List<HabitItem> = habitList.map { it.copy() }

    override fun toggleHabitCompleted(id: String) {
        val habitIndex = findHabitIndexById(id)
        val habit = habitList[habitIndex]
        habitList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted)
        sortListByChecked()
    }

    override fun addHabit(name: String, selectedHabitDays: List<Int>) {
        //todo: implement selectedHabitDays use
        habitList.add(
            HabitItem(
                id = UUID.randomUUID().toString(),
                title = name,
                isCompleted = false
            )
        )
    }

    private fun findHabitIndexById(id: String): Int = habitList.indexOfFirst { habitItem ->
        habitItem.id == id
    }

    private fun sortListByChecked() {
        habitList.sortBy { it.isCompleted }
    }
}