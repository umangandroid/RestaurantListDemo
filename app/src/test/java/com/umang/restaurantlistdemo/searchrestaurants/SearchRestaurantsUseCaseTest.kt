package com.umang.restaurantlistdemo.searchrestaurants

import com.umang.restaurantlistdemo.datasource.FakeRepository
import com.umang.restaurantlistdemo.domain.usecase.SearchRestaurantsUseCase
import com.umang.restaurantlistdemo.utils.CLOSED
import com.umang.restaurantlistdemo.utils.ORDER_AHEAD
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 *  Unit test implementation for [SearchRestaurantsUseCase].
 *  To check search operations applied on base list received from RestaurantDataSource
 */
class SearchRestaurantsUseCaseTest {

    private lateinit var searchRestaurantsUseCase: SearchRestaurantsUseCase

    @Before
    fun setupUseCase(){
        searchRestaurantsUseCase = SearchRestaurantsUseCase(FakeRepository())
    }

    /**
     * Verify search results for valid search query
     */
    @Test
    fun validSearchRestaurantsTest(){
        runBlocking {
            val results = searchRestaurantsUseCase.searchRestaurants("res")
            Assert.assertEquals(2,results?.size)
            Assert.assertEquals("Lale Restaurant & Snackbar", results?.get(0)?.name)
            Assert.assertEquals(ORDER_AHEAD, results?.get(0)?.status)
            Assert.assertEquals("Tandoori Express", results?.get(1)?.name)
            Assert.assertEquals(CLOSED, results?.get(1)?.status)
        }

    }

    @Test
    fun searchRestaurantsEmptySearchTest(){
        runBlocking {
            val results = searchRestaurantsUseCase.searchRestaurants("")
            Assert.assertEquals(0,results?.size)
        }
    }

    @Test
    fun searchRestaurantsNotFoundTest(){
        runBlocking {
            val results = searchRestaurantsUseCase.searchRestaurants("xyz")
            Assert.assertEquals(0,results?.size)
        }
    }

}