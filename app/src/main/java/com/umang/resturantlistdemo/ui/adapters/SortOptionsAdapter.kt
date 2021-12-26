package com.umang.resturantlistdemo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.umang.resturantlistdemo.R
import com.umang.resturantlistdemo.domain.model.SortOption
import com.umang.resturantlistdemo.ui.SortOptionClickListener
import com.umang.resturantlistdemo.ui.viewholders.SortOptionViewHolder

/**
 * Adapter for SortOptions
 */
class SortOptionsAdapter(private val sortOptionClickListener: SortOptionClickListener) :
    RecyclerView.Adapter<SortOptionViewHolder>() {

    private val sortOptionsList = ArrayList<SortOption>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortOptionViewHolder {
        return SortOptionViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_sort_option,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SortOptionViewHolder, position: Int) {
        holder.bind(sortOptionsList[position], sortOptionClickListener)
    }

    override fun getItemCount(): Int {
        return sortOptionsList.size
    }

    fun submitList(newList: List<SortOption>) {
        sortOptionsList.clear()
        sortOptionsList.addAll(newList)
        notifyDataSetChanged()

    }


}

