package br.com.coupledev.listadehabitos.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.coupledev.listadehabitos.core.repository.HabitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitFormViewModel @Inject constructor(
    private val habitRepository: HabitRepository
): ViewModel() {

    fun addHabit(name: String, selectedHabitDays: List<Int>) {
        viewModelScope.launch {
            habitRepository.add(name, selectedHabitDays)
        }
    }
}