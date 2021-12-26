package com.umang.resturantlistdemo.data

import com.umang.resturantlistdemo.domain.model.Restaurant

/**
 * To fetch data from RestaurantDataSource
 */
interface RestaurantRepository {
    suspend fun getBaseList():  List<Restaurant>?
}