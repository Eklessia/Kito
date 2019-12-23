package dev.nakamas.feature_breed.presentation.breeddetails

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.nakamas.feature_breed.R
import dev.nakamas.presentation.inflate
import kotlinx.android.synthetic.main.item_list_breed_image.view.*

class BreedDetailsAdapter constructor(private val itemClick: (String) -> Unit) :
    ListAdapter<String, BreedDetailsAdapter.ViewHolder>(BreedImageDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.inflate(R.layout.item_list_breed_image)) {

        fun bind(urlImage: String) {
            Picasso.get()
                .load(urlImage)
                .placeholder(R.drawable.place_holder_image)
                .into(itemView.ivBreedImage)
        }
    }
}

private class BreedImageDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}
