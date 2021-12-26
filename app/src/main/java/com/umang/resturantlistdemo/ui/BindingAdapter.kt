package com.umang.resturantlistdemo.ui

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.umang.resturantlistdemo.ui.viewmodels.SearchRestaurantsViewModel

/**
 * Add text change listener for search restaurants
 *
 * @param editText
 * @param viewModel
 */
@BindingAdapter("app:addTextChangeListener")
fun addTextChangeListener(editText: EditText, viewModel: ViewModel) {

    editText.doAfterTextChanged {
        when (viewModel) {
            is SearchRestaurantsViewModel -> viewModel.searchRestaurant(it.toString())
        }
    }
}

