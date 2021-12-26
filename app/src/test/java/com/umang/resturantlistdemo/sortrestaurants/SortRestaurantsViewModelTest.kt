package com.umang.resturantlistdemo.sortrestaurants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.umang.resturantlistdemo.MainCoroutineRule
import com.umang.resturantlistdemo.datasource.FakeRepository
import com.umang.resturantlistdemo.domain.model.SortOption
import com.umang.resturantlistdemo.domain.usecase.SortRestaurantsUseCase
import com.umang.resturantlistdemo.getOrAwaitValue
import com.umang.resturantlistdemo.ui.viewmodels.SearchRestaurantsViewModel
import com.umang.resturantlistdemo.ui.viewmodels.SortRestaurantsViewModel
import com.umang.resturantlistdemo.utils.BEST_MATCH
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 *  Unit test implementation for [SortRestaurantsViewModel]
 */
@ExperimentalCoroutinesApi
class SortRestaurantsViewModelTest {
    private lateinit var sortRestaurantsViewModel: SortRestaurantsViewModel
    private lateinit var sortOption:SortOption

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        sortOption = SortOption("Best Match", BEST_MATCH,true)
        sortRestaurantsViewModel = SortRestaurantsViewModel(SortRestaurantsUseCase(FakeRepository()))
    }

    @Test
    fun checkProgressStatusAndResultsSizeTest() {
        mainCoroutineRule.pauseDispatcher()
        sortRestaurantsViewModel.sortRestaurantsBy(sortOption)
        Assert.assertEquals(true,sortRestaurantsViewModel.progressStatus.getOrAwaitValue())
        mainCoroutineRule.resumeDispatcher()
        val list = sortRestaurantsViewModel.sortedRestaurantList.getOrAwaitValue()
        Assert.assertEquals(19,list.size)
        Assert.assertEquals(false,sortRestaurantsViewModel.progressStatus.getOrAwaitValue())
    }


}