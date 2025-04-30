package br.com.coupledev.listadehabitos.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress")
data class Progress(
    @PrimaryKey val uuid: String,
    val habitId: String,
    val completedAt: Long,
)
