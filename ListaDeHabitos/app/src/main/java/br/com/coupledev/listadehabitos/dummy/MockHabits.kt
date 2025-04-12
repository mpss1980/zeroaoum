package br.com.coupledev.listadehabitos.dummy

import br.com.coupledev.listadehabitos.collections.HabitItem
import java.util.UUID

object MockHabits {

    val habitItemList: MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Read the book",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Walk the dog",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Do the dishes",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Go to the gym",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Code every day",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of tea",
            isCompleted = false
        ),
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Make a cup of coffee",
            isCompleted = false
        )
    )
}