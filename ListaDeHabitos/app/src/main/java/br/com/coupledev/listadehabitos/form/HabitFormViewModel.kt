package br.com.coupledev.listadehabitos.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.coupledev.listadehabitos.core.repository.HabitRepository
import kotlinx.coroutines.launch

class HabitFormViewModel(
    private val habitRepository: HabitRepository
): ViewModel() {

    fun addHabit(name: String, selectedHabitDays: List<Int>) {
        viewModelScope.launch {
            habitRepository.add(name, selectedHabitDays)
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val habitRepository: HabitRepository,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HabitFormViewModel(
                habitRepository,
            ) as T
        }
    }
}