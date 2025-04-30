package br.com.coupledev.listadehabitos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.coupledev.listadehabitos.core.database.AppDatabase
import br.com.coupledev.listadehabitos.core.repository.HabitRepositoryImpl
import br.com.coupledev.listadehabitos.databinding.FragmentHabitFormBinding
import com.google.android.material.chip.Chip

class HabitFormFragment : Fragment() {

    private var _binding: FragmentHabitFormBinding? = null

    private val binding get() = _binding!!

    private val viewModel: HabitFormViewModel by activityViewModels {
        val db = AppDatabase.getInstance(requireContext())
        HabitFormViewModel.Factory(HabitRepositoryImpl(db))
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

        val selectedHabitDays = mutableListOf<Int>()
        for (id in binding.daysChipGroup.checkedChipIds) {
            val chip = binding.daysChipGroup.findViewById<Chip>(id)
            val position = binding.daysChipGroup.indexOfChild(chip)
            selectedHabitDays.add(position + 1)
        }

        viewModel.addHabit(habitName, selectedHabitDays)
        findNavController().navigateUp()
    }
}