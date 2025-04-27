package br.com.coupledev.listadehabitos.collections.domain

import br.com.coupledev.listadehabitos.collections.model.HabitItem

interface GetHabitForTodayUseCase {
    suspend operator fun invoke(): List<HabitItem>
}