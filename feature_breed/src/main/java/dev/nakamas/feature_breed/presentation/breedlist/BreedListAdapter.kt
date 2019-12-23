package dev.nakamas.feature_breed.presentation.breedlist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.nakamas.feature_breed.R
import dev.nakamas.presentation.inflate
import kotlinx.android.synthetic.main.item_list_breeds.view.*

class BreedListAdapter constructor(private val itemClick: (String) -> Unit) :
    ListAdapter<String, BreedListAdapter.ViewHolder>(BreedsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.item_list_breeds)) {

        fun bind(item: String) {
            itemView.tvNameBreed.text = item
            itemView.setOnClickListener { itemClick.invoke(item) }
        }
    }
}

private class BreedsDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}
