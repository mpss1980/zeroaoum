package br.com.coupledev.listadehabitos.dummy

import br.com.coupledev.listadehabitos.collections.HabitItem
import br.com.coupledev.listadehabitos.core.HabitRepository
import java.util.UUID

object MockHabits : HabitRepository {

    private val randomHabitList: MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Walk the dog",
            subTitle = "Every Day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Do the dishes",
            subTitle = "Every Day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Go to the gym",
            subTitle = "Every Week",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Code every day",
            subTitle = "Every Day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of tea",
            subTitle = "Every Day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of coffee",
            subTitle = "Every Hour",
            isCompleted = false
        )
    )

    private val habitList: MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Read the book",
            subTitle = "Every Weekend",
            isCompleted = false
        ),
    )

    override fun fetchHabits(): List<HabitItem> = habitList.map { it.copy() }

    override fun addRandomHabit() {
        habitList.add(randomHabit())
        sortListByChecked()
    }

    override fun toggleHabitCompleted(id: String) {
        val habitIndex = findHabitIndexById(id)
        val habit = habitList[habitIndex]
        habitList[habitIndex] = habit.copy(isCompleted = !habit.isCompleted)
        sortListByChecked()
    }

    private fun randomHabit() = randomHabitList.random().copy(
        id = UUID.randomUUID().toString()
    )

    private fun findHabitIndexById(id: String): Int = habitList.indexOfFirst { habitItem ->
        habitItem.id == id
    }

    private fun sortListByChecked() {
        habitList.sortBy { it.isCompleted }
    }
}