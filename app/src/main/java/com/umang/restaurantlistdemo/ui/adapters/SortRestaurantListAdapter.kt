package com.umang.restaurantlistdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.umang.restaurantlistdemo.R
import com.umang.restaurantlistdemo.domain.model.Restaurant
import com.umang.restaurantlistdemo.ui.viewholders.SortRestaurantViewHolder


/**
 * Sort restaurant list adapter
 * Used Normal RecyclerView.Adapter with DiffCallback as same list is used from DataSource for sort results
 */
class SortRestaurantListAdapter : RecyclerView.Adapter<SortRestaurantViewHolder>() {

    private val restaurantList = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortRestaurantViewHolder {
        return SortRestaurantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_sort_restaurant,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SortRestaurantViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    /**
     * Submit list
     *
     * @param newList
     */
    fun submitList(newList : List<Restaurant>){
         restaurantList.clear()
         restaurantList.addAll(newList)
         notifyDataSetChanged()
     }

}

