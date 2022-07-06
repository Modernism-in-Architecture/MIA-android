package org.modernism_in_architecture.mia.views.buildingsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import dagger.hilt.android.scopes.FragmentScoped
import org.modernism_in_architecture.mia.databinding.ItemBuildingsListBinding
import org.modernism_in_architecture.mia.domain.BuildingsListItem
import javax.inject.Inject

@FragmentScoped
class BuildingsListAdapter @Inject constructor(val clickListener: ClickListener) :
    ListAdapter<BuildingsListItem, BuildingsListAdapter.ViewHolder>(BuildingsListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ItemBuildingsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BuildingsListItem, clickListener: ClickListener) {
            binding.data = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBuildingsListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class BuildingsListDiffCallback : DiffUtil.ItemCallback<BuildingsListItem>() {

    override fun areItemsTheSame(oldItem: BuildingsListItem, newItem: BuildingsListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BuildingsListItem, newItem: BuildingsListItem): Boolean {
        return oldItem == newItem
    }

}

class ClickListener @Inject constructor() {

    var onItemClick: ((BuildingsListItem) -> Unit)? = null

    fun onClick(data: BuildingsListItem) {
        onItemClick?.invoke(data)
    }
}