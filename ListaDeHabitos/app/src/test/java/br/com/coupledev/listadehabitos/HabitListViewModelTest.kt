package br.com.coupledev.listadehabitos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.coupledev.listadehabitos.collections.HabitListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HabitListViewModelTest {

//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule()
//
//    private val repository = TestHabitRepository()
//    private val viewModel = HabitListViewModel(repository)
//
//    @Before
//    fun setup() {
//        repository.habitList.clear()
//    }
//
//    @Test
//    fun `Verify if uiState is init with data`() {
//        // Prepare
//        repository.addHabit(
//            "Name", listOf(1, 2, 3)
//        )
//
//        // Execute
//        val uiState = viewModel.stateOnceAndStream().getOrAwaitValue()
//
//        // Verify
//        assert(uiState.habitItemList.isNotEmpty())
//    }
//
//    @Test
//    fun `Verify if uiState is updated when habit is toggled`() {
//        // Prepare
//        repository.addHabit(
//            "Name", listOf(1, 2, 3)
//        )
//        val firstHabit = repository.habitList.first()
//        val firstHabitId = firstHabit.id
//        val isFirstHabitCompleted = firstHabit.isCompleted
//
//        // Execute
//        viewModel.toggleHabitCompleted(firstHabitId)
//        val uiState = viewModel.stateOnceAndStream().getOrAwaitValue()
//
//        // Verify
//        assert(uiState.habitItemList.first { it.id == firstHabitId }.isCompleted != isFirstHabitCompleted)
//    }
}