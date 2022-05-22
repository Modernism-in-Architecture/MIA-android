package org.modernism_in_architecture.mia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.modernism_in_architecture.mia.databinding.CardViewItemBinding
import org.modernism_in_architecture.mia.network.Building


class BuildingGridAdapter :
    ListAdapter<Building, BuildingGridAdapter.BuildingsViewHolder>(DiffCallback) {

    class BuildingsViewHolder(
        private var binding: CardViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(building: Building) {
            binding.building = building
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Building>() {
        override fun areItemsTheSame(oldItem: Building, newItem: Building): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Building, newItem: Building): Boolean {
            return oldItem.feedImage == newItem.feedImage
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuildingsViewHolder {
        return BuildingsViewHolder(
            CardViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: BuildingsViewHolder, position: Int) {
        val building = getItem(position)
        holder.bind(building)
    }
}