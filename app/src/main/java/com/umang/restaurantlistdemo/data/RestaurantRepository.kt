package com.umang.restaurantlistdemo.data

import com.umang.restaurantlistdemo.domain.model.Restaurant

/**
 * To fetch data from RestaurantDataSource
 */
interface RestaurantRepository {
    suspend fun getBaseList():  List<Restaurant>?
}