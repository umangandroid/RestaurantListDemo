package com.umang.restaurantlistdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.umang.restaurantlistdemo.databinding.FragmentSearchRestaurantsBinding
import com.umang.restaurantlistdemo.ui.adapters.SearchRestaurantsAdapter
import com.umang.restaurantlistdemo.ui.viewmodels.SearchRestaurantsViewModel
import com.umang.restaurantlistdemo.utils.showKeyboard
import dagger.hilt.android.AndroidEntryPoint

/**
 * Search restaurants fragment
 *
 */
@AndroidEntryPoint
class SearchRestaurantsFragment : Fragment() {

    private lateinit var adapter: SearchRestaurantsAdapter
    private lateinit var searchRestaurantsBinding: FragmentSearchRestaurantsBinding
    private val viewModel: SearchRestaurantsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchRestaurantsBinding =
            FragmentSearchRestaurantsBinding.inflate(inflater, container, false)
        return searchRestaurantsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchRestaurantsBinding.viewModel = viewModel //to bind search results and search query
        searchRestaurantsBinding.lifecycleOwner = this
        setupAdapter()
        setClickListeners()
        setDataObservers()
        searchRestaurantsBinding.etSearch.showKeyboard()
    }

    private fun setClickListeners() {
        searchRestaurantsBinding.ivBack.setOnClickListener {
            this.findNavController().popBackStack()
        }
    }

    private fun setDataObservers() {
        viewModel.filteredRestaurantList.observe(viewLifecycleOwner, {
            it?.let { restaurantList ->
                adapter.submitList(restaurantList)
                searchRestaurantsBinding.list.scrollToPosition(0)
            }

        })
    }

    private fun setupAdapter() {
        searchRestaurantsBinding.list.setHasFixedSize(true)
        adapter = SearchRestaurantsAdapter()
        searchRestaurantsBinding.list.adapter = adapter
    }

}

