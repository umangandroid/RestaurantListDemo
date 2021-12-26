package com.umang.resturantlistdemo.domain.usecase

import com.umang.resturantlistdemo.utils.*
import com.umang.resturantlistdemo.domain.model.Restaurant


/**
 * To simplify restaurant status comparison by make it int values
 * Restaurant status
 */
private val restaurantStatus: HashMap<String, Int> = hashMapOf(
    OPEN to 0,
    ORDER_AHEAD to 1,
    CLOSED to 2,

    )

/**
 * Sort comparator
 * Sorts ResaturantList by first restaurant status then by selected SortOption
 * @param sortOptionKey : Selected Sort Option key
 * @return : Comparison value between two restaurants
 */
fun sortComparator(sortOptionKey: String): java.util.Comparator<Restaurant> {
    return Comparator { r1: Restaurant, r2: Restaurant ->
        if (restaurantStatus[r1.status] != restaurantStatus[r2.status]) {
            return@Comparator restaurantStatus[r1.status]!! - restaurantStatus[r2.status]!!
        } else {
            return@Comparator when {
                sortOptionKey == BEST_MATCH && r1.sortingValues.bestMatch != r2.sortingValues.bestMatch
                -> r2.sortingValues.bestMatch.compareTo(r1.sortingValues.bestMatch)

                sortOptionKey == NEWEST && r1.sortingValues.newest != r2.sortingValues.newest
                -> r2.sortingValues.newest.compareTo(r1.sortingValues.newest)

                sortOptionKey == RATING_AVERAGE && r1.sortingValues.ratingAverage != r2.sortingValues.ratingAverage
                -> r2.sortingValues.ratingAverage.compareTo(r1.sortingValues.ratingAverage)

                sortOptionKey == DISTANCE && r1.sortingValues.distance != r2.sortingValues.distance
                -> r2.sortingValues.distance.compareTo(r1.sortingValues.distance)

                sortOptionKey == POPULARITY && r1.sortingValues.popularity != r2.sortingValues.popularity
                -> r2.sortingValues.popularity.compareTo(r1.sortingValues.popularity)

                sortOptionKey == AVERAGE_PRODUCT_PRICE && r1.sortingValues.averageProductPrice != r2.sortingValues.averageProductPrice
                -> r2.sortingValues.averageProductPrice.compareTo(r1.sortingValues.averageProductPrice)

                sortOptionKey == DELIVERY_COSTS && r1.sortingValues.deliveryCosts != r2.sortingValues.deliveryCosts
                -> r2.sortingValues.deliveryCosts.compareTo(r1.sortingValues.deliveryCosts)

                sortOptionKey == MIN_COST && r1.sortingValues.minCost != r2.sortingValues.minCost
                -> r2.sortingValues.minCost.compareTo(r1.sortingValues.minCost)

                else -> 0
            }
        }
    }
}

/**
 * Search comparator
 * Sort Search Restaurants by restaurant status to show restaurants in open, order ahead and closed orders
 * @return : comparison result between two restaurants
 */
fun searchComparator(): java.util.Comparator<Restaurant> {
    return Comparator { r1: Restaurant, r2: Restaurant ->
        return@Comparator if (restaurantStatus[r1.status] != restaurantStatus[r2.status]) {
            restaurantStatus[r1.status]!! - restaurantStatus[r2.status]!!
        } else {
            0
        }
    }
}

