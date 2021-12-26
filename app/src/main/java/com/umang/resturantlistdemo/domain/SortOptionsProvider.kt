package com.umang.resturantlistdemo.domain

import android.content.Context
import com.umang.resturantlistdemo.R
import com.umang.resturantlistdemo.domain.model.SortOption
import com.umang.resturantlistdemo.utils.*
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

/**
 * Sort options provider
 *
 * @property context : used to get string name from Strings.xml
 * @constructor Create empty Sort options provider
 */
@FragmentScoped
class SortOptionsProvider @Inject constructor(@ActivityContext val context: Context) {

    var sortOptionsList: ArrayList<SortOption>? = null

    init {
        getSortOptions()
    }

    /**
     * Get sort options
     *
     */
    private fun getSortOptions(){
        if (sortOptionsList == null) {
            sortOptionsList = ArrayList()
            sortOptionsList?.run {
                add(SortOption(context.getString(R.string.best_match), BEST_MATCH, true))
                add(SortOption(context.getString(R.string.newest), NEWEST))
                add(SortOption(context.getString(R.string.avg_rating), RATING_AVERAGE))
                add(SortOption(context.getString(R.string.distance), DISTANCE))
                add(SortOption(context.getString(R.string.popularity), POPULARITY))
                add(SortOption(context.getString(R.string.avg_price), AVERAGE_PRODUCT_PRICE))
                add(SortOption(context.getString(R.string.delivery_cost), DELIVERY_COSTS))
                add(SortOption(context.getString(R.string.min_cost), MIN_COST))
            }
        }
    }

    /**
     * Mark sort option selected
     *
     * @param sortOption
     */
    fun markSortOptionSelected(sortOption: SortOption) {
        sortOptionsList?.find { it.isSelected }?.isSelected = false
        sortOption.isSelected = true
    }
}