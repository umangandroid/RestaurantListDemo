package com.umang.restaurantlistdemo.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.databinding.ItemSearchRestaurantBinding

/**
 * Search restaurant view holder for SearchRestaurantAdapter
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