package com.umang.restaurantlistdemo.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.umang.restaurantlistdemo.databinding.ItemSortRestaurantBinding
import com.umang.restaurantlistdemo.domain.model.Restaurant

/**
 * Sort restaurant view holder for SortRestaurantListAdapter
 *
 * @property binding
 */
class SortRestaurantViewHolder(
        private val binding: ItemSortRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.apply {
                restaurant = item
                executePendingBindings()
            }
        }
    }