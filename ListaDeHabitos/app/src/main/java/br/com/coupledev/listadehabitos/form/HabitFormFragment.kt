package br.com.coupledev.listadehabitos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.coupledev.listadehabitos.databinding.FragmentHabitFormBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HabitFormFragment : Fragment() {

    private var _binding: FragmentHabitFormBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: HabitFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HabitFormViewModel::class.java]
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