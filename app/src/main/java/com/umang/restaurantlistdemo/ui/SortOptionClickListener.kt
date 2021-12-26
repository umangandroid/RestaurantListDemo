package com.umang.restaurantlistdemo.ui

import com.umang.restaurantlistdemo.domain.model.SortOption

/**
 * Sort option click listener to change sort option
 *
 */
interface SortOptionClickListener {
    fun onSortOptionClick(sortOption: SortOption)
}