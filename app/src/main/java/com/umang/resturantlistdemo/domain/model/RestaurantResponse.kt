package com.umang.resturantlistdemo.domain.model


/**
 * Restaurant response parent element
 *
 * @property restaurants : restaurants list
 */
data class RestaurantResponse(
    val restaurants: List<Restaurant>
)