package com.umang.restaurantlistdemo.searchrestaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.umang.restaurantlistdemo.MainCoroutineRule
import com.umang.restaurantlistdemo.datasource.FakeRepository
import com.umang.restaurantlistdemo.domain.usecase.SearchRestaurantsUseCase
import com.umang.restaurantlistdemo.getOrAwaitValue
import com.umang.restaurantlistdemo.ui.viewmodels.SearchRestaurantsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Unit test implementation for [SearchRestaurantsViewModel]
 */
@ExperimentalCoroutinesApi
class SearchRestaurantsViewModelTest {
    private lateinit var searchRestaurantsViewModel: SearchRestaurantsViewModel

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        searchRestaurantsViewModel = SearchRestaurantsViewModel(SearchRestaurantsUseCase(
            FakeRepository()
        ))
    }

    @Test
    fun searchRestaurantsTest() {
        mainCoroutineRule.pauseDispatcher()
        searchRestaurantsViewModel.searchRestaurant("res")
        mainCoroutineRule.resumeDispatcher()
        val list = searchRestaurantsViewModel.filteredRestaurantList.getOrAwaitValue()
        Assert.assertEquals(2,list?.size)
        Assert.assertEquals(false,searchRestaurantsViewModel.noDataMessage.getOrAwaitValue())
    }

    @Test
    fun searchRestaurantsEmptySearchTest() {
        mainCoroutineRule.pauseDispatcher()
        searchRestaurantsViewModel.searchRestaurant("")
        mainCoroutineRule.resumeDispatcher()
        val list = searchRestaurantsViewModel.filteredRestaurantList.getOrAwaitValue()
        Assert.assertEquals(0,list?.size)
        Assert.assertEquals(false,searchRestaurantsViewModel.noDataMessage.getOrAwaitValue())
    }

    @Test
    fun searchRestaurantsNoResultsTest() {
        mainCoroutineRule.pauseDispatcher()
        searchRestaurantsViewModel.searchRestaurant("xyz")
        mainCoroutineRule.resumeDispatcher()
        val list = searchRestaurantsViewModel.filteredRestaurantList.getOrAwaitValue()
        Assert.assertEquals(0,list?.size)
        Assert.assertEquals(true,searchRestaurantsViewModel.noDataMessage.getOrAwaitValue())
    }


}