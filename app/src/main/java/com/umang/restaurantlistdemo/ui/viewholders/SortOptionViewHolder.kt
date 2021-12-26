package com.umang.restaurantlistdemo.ui.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.umang.restaurantlistdemo.databinding.ItemSortOptionBinding
import com.umang.restaurantlistdemo.domain.model.SortOption
import com.umang.restaurantlistdemo.ui.SortOptionClickListener

/**
 * Sort option view holder for SortOptionsAdapter
 *
 * @property binding
 */
class SortOptionViewHolder(
    private val binding: ItemSortOptionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SortOption, sortOptionClickListener: SortOptionClickListener) {
            binding.apply {
                sortOption = item
                setClickListener {
                    sortOptionClickListener.onSortOptionClick(item)
                }

            }
        }
    }