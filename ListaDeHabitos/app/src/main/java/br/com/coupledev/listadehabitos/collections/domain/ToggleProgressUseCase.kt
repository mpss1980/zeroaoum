package br.com.coupledev.listadehabitos.collections.domain

interface ToggleProgressUseCase {
    suspend operator fun invoke(habitId: String)
}