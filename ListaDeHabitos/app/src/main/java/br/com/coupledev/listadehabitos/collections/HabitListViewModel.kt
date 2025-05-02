package br.com.coupledev.listadehabitos.collections

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.coupledev.listadehabitos.collections.domain.GetHabitForTodayUseCase
import br.com.coupledev.listadehabitos.collections.domain.ToggleProgressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitListViewModel @Inject constructor(
    private val toggleProgressUseCase: ToggleProgressUseCase,
    private val getHabitForTodayUseCase: GetHabitForTodayUseCase,
) : ViewModel() {
    private val state: MutableLiveData<HabitListState> by lazy {
        MutableLiveData<HabitListState>(HabitListState(habitItemList = emptyList()))
    }

    fun onResume() {
        viewModelScope.launch {
            refreshHabitList()
        }
    }

    fun stateOnceAndStream(): LiveData<HabitListState> = state

    fun toggleHabitCompleted(habitId: String) {
        viewModelScope.launch {
            toggleProgressUseCase(habitId)
            refreshHabitList()
        }
    }

    private suspend fun refreshHabitList() {
        state.postValue(HabitListState(getHabitForTodayUseCase()))
    }
}