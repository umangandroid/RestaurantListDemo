package com.umang.restaurantlistdemo.data

import com.umang.restaurantlistdemo.domain.model.Restaurant
import javax.inject.Inject

/**
 * Multiple Datasource can be placed here to fetch data from data source
 */
class RestaurantRepositoryImpl @Inject constructor (private val restaurantDataSource: RestaurantDataSource) :RestaurantRepository {

    override suspend fun getBaseList(): List<Restaurant>? {
        return restaurantDataSource.getBaseList()
    }
}