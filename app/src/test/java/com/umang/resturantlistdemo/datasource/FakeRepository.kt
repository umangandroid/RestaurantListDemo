package com.umang.resturantlistdemo.datasource

import com.google.gson.Gson
import com.umang.resturantlistdemo.data.RestaurantRepository
import com.umang.resturantlistdemo.domain.model.Restaurant
import com.umang.resturantlistdemo.domain.model.RestaurantResponse

/**
 * Repository class used for unit tests to get [Restaurant] list
 */
class FakeRepository :RestaurantRepository{


    override suspend fun getBaseList(): List<Restaurant>? {
        return Gson().fromJson(responseString, RestaurantResponse::class.java)?.restaurants
    }
}