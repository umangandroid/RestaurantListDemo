package com.umang.resturantlistdemo.domain.model

/**
 * Sort option used to display all sort options available for sorting
 *
 * @property name : Sort option name
 * @property sortOptKey : Used to sort restaurants by
 * @property isSelected : True for current selected sort option
 */
data class SortOption(val name: String, val sortOptKey: String, var isSelected:Boolean =false)
