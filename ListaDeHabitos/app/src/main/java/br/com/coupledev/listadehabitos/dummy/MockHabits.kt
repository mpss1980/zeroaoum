package br.com.coupledev.listadehabitos.dummy

import br.com.coupledev.listadehabitos.collections.HabitItem
import java.util.UUID

object MockHabits {

    val habitItemList: MutableList<HabitItem> = mutableListOf(
        HabitItem(
            id = UUID.randomUUID().toString(),
            title = "Read the book",
            subTitle = "Every Weekend",
            isCompleted = false
        ),
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
}