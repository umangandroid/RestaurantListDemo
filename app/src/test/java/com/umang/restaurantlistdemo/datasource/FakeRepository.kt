package com.umang.restaurantlistdemo.datasource

import com.google.gson.Gson
import com.umang.restaurantlistdemo.data.RestaurantRepository
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.domain.model.RestaurantResponse

/**
 * Repository class used for unit tests to get [Restaurant] list
 */
class FakeRepository :RestaurantRepository{


    override suspend fun getBaseList(): List<Restaurant>? {
        return Gson().fromJson(responseString, RestaurantResponse::class.java)?.restaurants
    }
}