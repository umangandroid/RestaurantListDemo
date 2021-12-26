package com.umang.restaurantlistdemo.domain.model

/**
 * Restaurant object used to show list in sort and search screen
 *
 * @property id
 * @property name
 * @property sortingValues
 * @property status
 * @property selectedSort : Display current sort applied with its value for [Restaurant]
 */
data class Restaurant(
    val id: String,
    val name: String,
    val sortingValues: SortingValues,
    val status: String,
    var selectedSort :String
)