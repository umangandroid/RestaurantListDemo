package com.umang.restaurantlistdemo

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Includes different UI tests for Sort restaurants
 */
@RunWith(AndroidJUnit4::class)
class SortRestaurantsTest : BaseTest() {

    /**
     * To check restaurants list with default sort apply(Best Match)
     */
    @Test
    fun verifyInitialSort() {
        verifyViewWithText("Restaurants")
        verifyViewInList(R.id.list, 0, "Lunchpakketdienst")
        verifyViewInList(R.id.list, 0, "Best Match : 306.0")
        verifyViewInList(R.id.list, 0, "open")
        clickView(R.id.fabSort)
        verifyViewInList(R.id.rvSortOptions, 0, "Best Match")
        verifyViewShowInList(R.id.rvSortOptions, 0, R.id.ivSelected)
    }

    /**
     * To check sort value from Best match to Average rating and verify restaurants list with updated
     * values and verifies sort option changes
     */
    @Test
    fun verifyChangeSort() {
        verifyViewInList(R.id.list, 0, "Lunchpakketdienst")
        verifyViewInList(R.id.list, 0, "Best Match : 306.0")
        verifyViewInList(R.id.list, 0, "open")
        clickView(R.id.fabSort)
        clickOnListItemView(2, R.id.conContainer, R.id.rvSortOptions)
        verifyViewInList(R.id.list, 0, "Tanoshii Sushi")
        verifyViewInList(R.id.list, 0, "Average Rating : 4.5")
        verifyViewInList(R.id.list, 0, "open")
        clickView(R.id.fabSort)
        verifyViewInList(R.id.rvSortOptions, 2, "Best Match")
        verifyViewShowInList(R.id.rvSortOptions, 2, R.id.ivSelected)

    }

}