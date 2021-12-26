package com.umang.restaurantlistdemo.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.domain.model.SortOption
import com.umang.restaurantlistdemo.domain.usecase.SortRestaurantsUseCase
import com.umang.restaurantlistdemo.utils.EspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Sort restaurants view model
 *
 * @property sortRestaurantsUseCase
 */
@HiltViewModel
class SortRestaurantsViewModel @Inject constructor(
    private val sortRestaurantsUseCase: SortRestaurantsUseCase
) :
    ViewModel() {
    val sortedRestaurantList = MutableLiveData<List<Restaurant>>() // sort results list
    var progressStatus = MutableLiveData(true) // progressbar status

    /**
     * Sort restaurants by sort option
     *
     * @param sortOption : selected sort option
     */
    fun sortRestaurantsBy(sortOption: SortOption) {
        viewModelScope.launch(Dispatchers.IO) {
            EspressoIdlingResource.increment()
            progressStatus.postValue(true)
            sortedRestaurantList.postValue(sortRestaurantsUseCase.sortAndFormatList(sortOption))
            progressStatus.postValue(false)
            EspressoIdlingResource.decrement()
        }
    }

}