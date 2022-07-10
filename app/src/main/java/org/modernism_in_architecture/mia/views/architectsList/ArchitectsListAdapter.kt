package org.modernism_in_architecture.mia.views.architectsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.scopes.FragmentScoped
import org.modernism_in_architecture.mia.databinding.ItemArchitectsListBinding
import org.modernism_in_architecture.mia.domain.ArchitectsListItem
import javax.inject.Inject

@FragmentScoped
class ArchitectsListAdapter @Inject constructor(val clickListener: ArchitectsClickListener) :
    ListAdapter<ArchitectsListItem, ArchitectsListAdapter.ViewHolder>(ArchitectsListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemArchitectsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ArchitectsListItem, clickListener: ArchitectsClickListener) {
            binding.data = item
            binding.executePendingBindings()
            binding.architectsClickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemArchitectsListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class ArchitectsListDiffCallback : DiffUtil.ItemCallback<ArchitectsListItem>() {

    override fun areItemsTheSame(oldItem: ArchitectsListItem, newItem: ArchitectsListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ArchitectsListItem, newItem: ArchitectsListItem): Boolean {
        return oldItem == newItem
    }

}

class ArchitectsClickListener @Inject constructor() {

    var onItemClick: ((ArchitectsListItem) -> Unit)? = null

    fun onClick(data: ArchitectsListItem) {
        onItemClick?.invoke(data)
    }
}