package br.com.coupledev.listadehabitos.core.database

import androidx.room.TypeConverter

class DaysOfWeekConverter {

    @TypeConverter
    fun toDaysOfWeek(value: String): List<Int> {
        return value.split(",").map { it.toInt() }
    }

    @TypeConverter
    fun fromDaysOfWeek(daysOfWeek: List<Int>): String {
        return daysOfWeek.joinToString(",")
    }
}