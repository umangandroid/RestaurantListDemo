package com.umang.resturantlistdemo.ui

import com.umang.resturantlistdemo.domain.model.SortOption

/**
 * Sort option click listener to change sort option
 *
 */
interface SortOptionClickListener {
    fun onSortOptionClick(sortOption: SortOption)
}