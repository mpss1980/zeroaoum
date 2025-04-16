package br.com.coupledev.listadehabitos.collections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.coupledev.listadehabitos.databinding.HabitItemBinding

class HabitListAdapter : RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {

    private val asyncListDiffer: AsyncListDiffer<HabitItem> =
        AsyncListDiffer(this, DiffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HabitItemBinding.inflate(layoutInflater, parent, false)
        return HabitViewHolder(binding)
    }

    override fun getItemCount(): Int = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    fun updateHabits(habits: List<HabitItem>) {
        asyncListDiffer.submitList(habits)
    }

    class HabitViewHolder(private val binding: HabitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(habit: HabitItem) {
            binding.titleTextView.text = habit.title
            binding.subTitleTextView.text = habit.subTitle
            binding.completeCheckBox.isChecked = habit.isCompleted
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