package br.com.coupledev.listadehabitos.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.coupledev.listadehabitos.core.HabitRepository

class HabitListViewModel(private val repository: HabitRepository) : ViewModel() {
    private val state: MutableLiveData<HabitListState> by lazy {
        MutableLiveData<HabitListState>(HabitListState(habitItemList = repository.fetchHabits()))
    }

    fun stateOnceAndStream(): LiveData<HabitListState> = state

    fun addHabit(name: String, selectedHabitDays: List<Int>) {
        repository.addHabit(name, selectedHabitDays)
        refreshState()
    }

    fun toggleHabitCompleted(id: String) {
        repository.toggleHabitCompleted(id)
        refreshState()
    }

    private fun refreshState() {
        state.value?.let { currentState ->
            state.value = currentState.copy(habitItemList = repository.fetchHabits())
        }
    }

    class Factory(private val repository: HabitRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HabitListViewModel(repository) as T
        }
    }
}