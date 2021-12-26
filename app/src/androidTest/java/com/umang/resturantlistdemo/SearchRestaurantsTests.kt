package com.umang.resturantlistdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Includes different UI tests for search restaurants
 */
@RunWith(AndroidJUnit4::class)
class SearchRestaurantsTests :BaseTest(){

    /**
     * Search restaurants with string having results
     */
    @Test
    fun validSearchRestaurantTest(){
        clickView(R.id.tvSearch)
        fillEditText(R.id.etSearch,"res")
        verifyViewInList(R.id.list,0,"Lale Restaurant & Snackbar")
        verifyViewInList(R.id.list,1,"Tandoori Express")
    }

    /**
     * Verifies behaviour for cleared search field
     */
    @Test
    fun emptySearchRestaurantTest(){
        clickView(R.id.tvSearch)
        fillEditText(R.id.etSearch,"res")
        Assert.assertEquals(2,getCountFromRecyclerView(R.id.list))
        clearEditTextBox(R.id.etSearch)
        Thread.sleep(300)
        Assert.assertEquals(0,getCountFromRecyclerView(R.id.list))
    }

    /**
     * Verifies no results message when no matching restaurants found with search text
     */
    @Test
    fun noSearchResultsFoundTest(){
        onView(withId(R.id.tvSearch)).perform(click())
        fillEditText(R.id.etSearch,"xyz")
        Assert.assertEquals(0,getCountFromRecyclerView(R.id.list))
        verifyViewWithText("No Restaurants found")
    }


}