package com.umang.resturantlistdemo.data

import android.content.Context
import com.google.gson.Gson
import com.umang.resturantlistdemo.domain.model.Restaurant
import com.umang.resturantlistdemo.domain.model.RestaurantResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Fetches data from json file.Making it singleton makes cached data available for SearchRestaurantsFragment
 */
@Singleton
class RestaurantDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    private var baseList: List<Restaurant>? = null


    private fun parseListFromFile(): List<Restaurant> {
        val jsonFileString = getJsonDataFromAsset()
        return Gson().fromJson(jsonFileString, RestaurantResponse::class.java)?.restaurants?: listOf()
    }

    /**
     * For first time fetch data from json file.For next requests use stored list.
     */
    fun getBaseList(): List<Restaurant>? {
        if (baseList == null)
            baseList = parseListFromFile()
        return baseList
    }

    fun getJsonDataFromAsset(): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("consumer.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


}