package br.com.coupledev.listadehabitos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import br.com.coupledev.listadehabitos.collections.HabitListViewModel
import br.com.coupledev.listadehabitos.databinding.FragmentHabitFormBinding
import br.com.coupledev.listadehabitos.databinding.FragmentHabitListBinding
import br.com.coupledev.listadehabitos.dummy.MockHabits

class HabitFormFragment : Fragment() {

    private var _binding: FragmentHabitFormBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HabitListViewModel by activityViewModels {
        HabitListViewModel.Factory(MockHabits)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener { onSave() }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onSave() {
        val habitName = binding.titleTextInput.editText?.text.toString()
        val selectedHabitDays = binding.daysChipGroup.checkedChipIds
        viewModel.addHabit(habitName, selectedHabitDays)
        findNavController().navigateUp()
    }
}