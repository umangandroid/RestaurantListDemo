package com.umang.restaurantlistdemo.domain.usecase

import com.umang.restaurantlistdemo.data.RestaurantRepository
import com.umang.restaurantlistdemo.domain.model.Restaurant
import javax.inject.Inject

/**
 * Search restaurants use case
 *
 * @property restaurantRepository : Provides base restaurants list
 */
class SearchRestaurantsUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {
    /**
     * Search restaurants
     * apply filter by text on base list and sort it by restaurant status
     * @param searchText
     * @return filtered restaurants list. Return empty list no match found.
     */
    suspend fun searchRestaurants(searchText: String): List<Restaurant>? {
        val baseList = restaurantRepository.getBaseList()
        val filteredList = if (searchText.isEmpty()) listOf() else baseList?.filter { it.name.contains(searchText.trim(), true) }
        return filteredList?.sortedWith(searchComparator())
    }
}