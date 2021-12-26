package com.umang.restaurantlistdemo.domain.usecase

import com.umang.restaurantlistdemo.data.RestaurantRepository
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.domain.model.SortOption
import com.umang.restaurantlistdemo.utils.*
import javax.inject.Inject

/**
 * Sort restaurants use case
 *
 * @property restaurantRepository : Provides base restaurants list
 */
class SortRestaurantsUseCase @Inject constructor(private val restaurantRepository: RestaurantRepository) {

    /**
     * Sort and format list
     *
     * @param sortOption : selected sort option
     * @return : sort applied list
     */
    suspend fun sortAndFormatList(sortOption: SortOption): List<Restaurant>? {
        val sortedList =
            restaurantRepository.getBaseList()?.sortedWith(sortComparator(sortOption.sortOptKey))
        return mapListToAddDisplaySortValue(sortOption, sortedList)
    }

    /**
     * Map list to add display sort value
     *
     * @param sortOption : selected sort option
     * @param list : list with current sort option with its value added in each Restaurant object
     * @return : list
     */
    private fun mapListToAddDisplaySortValue(sortOption: SortOption,list: List<Restaurant>?): List<Restaurant>? {
        list?.map { restaurant ->
            restaurant.selectedSort = when (sortOption.sortOptKey) {
                BEST_MATCH -> "${sortOption.name} : ${restaurant.sortingValues.bestMatch}"
                NEWEST -> "${sortOption.name} : ${restaurant.sortingValues.newest}"
                RATING_AVERAGE -> "${sortOption.name} : ${restaurant.sortingValues.ratingAverage}"
                DISTANCE -> "${sortOption.name} : ${restaurant.sortingValues.distance}"
                POPULARITY -> "${sortOption.name} : ${restaurant.sortingValues.popularity}"
                AVERAGE_PRODUCT_PRICE -> "${sortOption.name} : ${restaurant.sortingValues.averageProductPrice}"
                DELIVERY_COSTS -> "${sortOption.name} : ${restaurant.sortingValues.deliveryCosts}"
                MIN_COST -> "${sortOption.name} : ${restaurant.sortingValues.minCost}"
                else ->
                    ""
            }
        }
        return list
    }
}


