package com.umang.restaurantlistdemo.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.domain.usecase.SearchRestaurantsUseCase
import com.umang.restaurantlistdemo.utils.EspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Search restaurants view model
 *
 * @property searchRestaurantsUseCase
 */
@HiltViewModel
class SearchRestaurantsViewModel @Inject constructor(private val searchRestaurantsUseCase: SearchRestaurantsUseCase) :
    ViewModel() {
    private var mSearchJob: Job? = null // holds search job
    val filteredRestaurantList = MutableLiveData<List<Restaurant>?>() //filtered restaurants list
    val noDataMessage = MutableLiveData(false) // status for no data message true when no results found for search text

    /**
     * Search restaurant
     *
     * @param searchText
     */
    fun searchRestaurant(searchText: String) {
        noDataMessage.value =false
        mSearchJob?.cancel() // cancel previous search query if not complete
        mSearchJob = viewModelScope.launch(Dispatchers.IO) {
            EspressoIdlingResource.increment()
            delay(200)
            val resultsList = searchRestaurantsUseCase.searchRestaurants(searchText)
            EspressoIdlingResource.decrement()
            filteredRestaurantList.postValue(resultsList)
            if (resultsList.isNullOrEmpty() && searchText.isNotEmpty()) {
                noDataMessage.postValue(true)
            }
        }
    }
}