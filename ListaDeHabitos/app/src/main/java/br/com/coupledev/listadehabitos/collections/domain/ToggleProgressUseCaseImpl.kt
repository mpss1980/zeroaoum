package br.com.coupledev.listadehabitos.collections.domain

import br.com.coupledev.listadehabitos.core.repository.ProgressRepository
import java.util.Calendar

class ToggleProgressUseCaseImpl(
    private val progressRepository: ProgressRepository,
) : ToggleProgressUseCase {
    override suspend fun invoke(habitId: String) {
        val today = Calendar.getInstance()
        val progress = progressRepository.fetch(habitId, today.timeInMillis)

        //todo: não está deletando a progress corretamente
        if (progress.isNotEmpty()) {
            progressRepository.delete(habitId)
        } else {
            progressRepository.add(habitId)
        }
    }
}