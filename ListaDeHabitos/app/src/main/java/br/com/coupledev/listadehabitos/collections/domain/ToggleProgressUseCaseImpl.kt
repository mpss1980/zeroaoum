package br.com.coupledev.listadehabitos.collections.domain

import br.com.coupledev.listadehabitos.core.repository.ProgressRepository
import java.util.Calendar
import javax.inject.Inject

class ToggleProgressUseCaseImpl @Inject constructor(
    private val progressRepository: ProgressRepository,
) : ToggleProgressUseCase {
    override suspend fun invoke(habitId: String) {
        val today = Calendar.getInstance()
        val progress = progressRepository.fetch(habitId, today.timeInMillis)

        if (progress.isNotEmpty()) {
            progressRepository.delete(progress.first().id)
        } else {
            progressRepository.add(habitId)
        }
    }
}