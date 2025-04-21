package br.com.coupledev.listadehabitos.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.coupledev.listadehabitos.databinding.HabitItemBinding

class HabitListAdapter(private val viewModel: HabitListViewModel) :
    RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {

    private val asyncListDiffer: AsyncListDiffer<HabitItem> =
        AsyncListDiffer(this, DiffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HabitItemBinding.inflate(layoutInflater, parent, false)
        return HabitViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    fun updateHabits(habits: List<HabitItem>) {
        asyncListDiffer.submitList(habits)
    }

    class HabitViewHolder(
        private val binding: HabitItemBinding,
        private val viewModel: HabitListViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: HabitItem) {
            binding.titleTextView.text = habit.title
            binding.subTitleTextView.text = habit.subTitle
            binding.completeCheckBox.isChecked = habit.isCompleted

            val textColor =
                if (habit.isCompleted)
                    binding.root.context.getColor(android.R.color.darker_gray)
                else
                    binding.root.context.getColor(android.R.color.black)

            binding.titleTextView.setTextColor(textColor)
            binding.subTitleTextView.setTextColor(textColor)

            binding.completeCheckBox.setOnClickListener {
                viewModel.toggleHabitCompleted(habit.id)
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<HabitItem>() {
        override fun areItemsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HabitItem, newItem: HabitItem): Boolean {
            return oldItem == newItem
        }
    }
}