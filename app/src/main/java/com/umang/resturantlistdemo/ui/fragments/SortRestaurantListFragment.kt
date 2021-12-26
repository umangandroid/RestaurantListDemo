package com.umang.resturantlistdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.umang.resturantlistdemo.R
import com.umang.resturantlistdemo.databinding.BottomSheetSortBinding
import com.umang.resturantlistdemo.databinding.FragmentSortRestaurantListBinding
import com.umang.resturantlistdemo.domain.SortOptionsProvider
import com.umang.resturantlistdemo.domain.model.SortOption
import com.umang.resturantlistdemo.ui.SortOptionClickListener
import com.umang.resturantlistdemo.ui.adapters.SortOptionsAdapter
import com.umang.resturantlistdemo.ui.adapters.SortRestaurantListAdapter
import com.umang.resturantlistdemo.ui.viewmodels.SortRestaurantsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Sort restaurant list fragment
 *
 */
@AndroidEntryPoint
class SortRestaurantListFragment : Fragment() {

    private lateinit var adapter: SortRestaurantListAdapter
    private lateinit var sortRestaurantListBinding: FragmentSortRestaurantListBinding
    private val viewModel: SortRestaurantsViewModel by viewModels()

    @Inject
    lateinit var sortOptionsProvider: SortOptionsProvider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sortRestaurantListBinding =
            FragmentSortRestaurantListBinding.inflate(inflater, container, false)
        return sortRestaurantListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sortRestaurantListBinding.viewModel = viewModel //to bind progress visibility
        sortRestaurantListBinding.lifecycleOwner = this
        setupListAdapter()
        setupClickListeners()
        setDataObservers()
        //initiate sort with default sort option (Best Match)
        sortOptionsProvider.sortOptionsList?.find { it.isSelected }?.let { viewModel.sortRestaurantsBy(it) }
    }

    private fun setDataObservers() {
        viewModel.sortedRestaurantList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
            sortRestaurantListBinding.list.scrollToPosition(0)
        })
    }

    private fun setupClickListeners() {
        sortRestaurantListBinding.fabSort.setOnClickListener {
            openSortOptions()
        }
        sortRestaurantListBinding.tvSearch.setOnClickListener { //Open search restaurants screen
            NavHostFragment.findNavController(this).navigate(R.id.searchRestaurantsFragment)
        }
    }

    /**
     * Show list of available sort options to choose from
     *
     */
    private fun openSortOptions() {
        val dialog = BottomSheetDialog(requireContext())
        val bottomSheetSortBinding =
            BottomSheetSortBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        val sortOptionsAdapter = SortOptionsAdapter(object : SortOptionClickListener {
            override fun onSortOptionClick(sortOption: SortOption) {
                dialog.dismiss()
                sortOptionsProvider.markSortOptionSelected(sortOption)
                viewModel.sortRestaurantsBy(sortOption) //initiate sort by selected sort
            }
        })
        bottomSheetSortBinding.rvSortOptions.adapter = sortOptionsAdapter
        sortOptionsProvider.sortOptionsList?.let { sortOptionsAdapter.submitList(it) }
        dialog.setCancelable(true)
        dialog.setContentView(bottomSheetSortBinding.root)
        dialog.show()
    }

    private fun setupListAdapter() {
        sortRestaurantListBinding.list.setHasFixedSize(true)
        adapter = SortRestaurantListAdapter()
        sortRestaurantListBinding.list.adapter = adapter
    }
}