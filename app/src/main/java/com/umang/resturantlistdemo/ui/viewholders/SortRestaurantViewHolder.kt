package com.umang.resturantlistdemo.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.umang.resturantlistdemo.databinding.ItemSortRestaurantBinding
import com.umang.resturantlistdemo.domain.model.Restaurant

/**
 * Sort restaurant view holder for [SortRestaurantListAdapter]
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