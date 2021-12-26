package com.umang.resturantlistdemo.domain.model

/**
 * Sorting values
 *
 * @property averageProductPrice
 * @property bestMatch
 * @property deliveryCosts
 * @property distance
 * @property minCost
 * @property newest
 * @property popularity
 * @property ratingAverage
 */
data class SortingValues(
    val averageProductPrice: Int,
    val bestMatch: Double,
    val deliveryCosts: Int,
    val distance: Int,
    val minCost: Int,
    val newest: Double,
    val popularity: Double,
    val ratingAverage: Double
)