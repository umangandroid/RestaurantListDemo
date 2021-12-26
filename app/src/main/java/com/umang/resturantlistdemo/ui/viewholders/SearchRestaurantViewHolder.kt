package com.umang.resturantlistdemo.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.umang.resturantlistdemo.domain.model.Restaurant
import com.umang.resturantlistdemo.databinding.ItemSearchRestaurantBinding

/**
 * Search restaurant view holder for [SearchRestaurantAdapter]
 *
 * @property binding
 */
class SearchRestaurantViewHolder(
    private val binding: ItemSearchRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.apply {
                restaurant = item
                executePendingBindings()
            }
        }
    }