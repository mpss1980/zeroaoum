package br.com.coupledev.listadehabitos.collections

import HabitListItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.coupledev.listadehabitos.R
import br.com.coupledev.listadehabitos.databinding.FragmentHabitListBinding
import br.com.coupledev.listadehabitos.dummy.MockHabits
import com.google.android.material.divider.MaterialDividerItemDecoration

class HabitListFragment : Fragment() {

    private var _binding: FragmentHabitListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: HabitListAdapter

    private val viewModel: HabitListViewModel by activityViewModels {
        HabitListViewModel.Factory(MockHabits)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = HabitListAdapter(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHabitListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.habitRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.habitRecyclerView.adapter = adapter

        addingDividerDecoration()
        addingDividerSpace()
        viewModel.stateOnceAndStream()
            .observe(viewLifecycleOwner) { state ->
                bindState(state)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun addingDividerDecoration() {
        val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        divider.isLastItemDecorated = false

        val resources = requireContext().resources
        divider.dividerInsetStart = resources.getDimensionPixelSize(R.dimen.horizontal_margin)
        divider.dividerThickness = resources.getDimensionPixelSize(R.dimen.divider_height)
        divider.dividerColor = ContextCompat.getColor(requireContext(), R.color.primary_200)

        binding.habitRecyclerView.addItemDecoration(divider)
    }

    private fun addingDividerSpace() {
        binding.habitRecyclerView.addItemDecoration(HabitListItemDecoration(requireContext()))
    }

    private fun bindState(state: HabitListState) {
        adapter.updateHabits(state.habitItemList)
    }
}