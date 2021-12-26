package com.umang.resturantlistdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.umang.resturantlistdemo.R
import com.umang.resturantlistdemo.domain.model.Restaurant
import com.umang.resturantlistdemo.ui.viewholders.SearchRestaurantViewHolder


/**
 * Search restaurants adapter
 * Used Normal RecyclerView.Adapter with DiffCallback as same list is used from DataSource for search queries
 */
class SearchRestaurantsAdapter : RecyclerView.Adapter<SearchRestaurantViewHolder>() {

    private val restaurantList = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRestaurantViewHolder {
        return SearchRestaurantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search_restaurant,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchRestaurantViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    /**
     * Submit list
     *
     * @param list
     */
    fun submitList(list: List<Restaurant>) {
        restaurantList.clear()
        restaurantList.addAll(list)
        notifyDataSetChanged()
    }
}

