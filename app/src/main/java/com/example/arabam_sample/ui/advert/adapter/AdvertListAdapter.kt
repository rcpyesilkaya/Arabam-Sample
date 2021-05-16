package com.example.arabam_sample.ui.advert.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arabam_sample.R
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.databinding.ItemRecyclerViewBinding

class AdvertListAdapter : PagedListAdapter<CarResponse, AdvertListAdapter.AdvertViewHolder>(
    diffUtilCallBack
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertViewHolder {
        val binding = DataBindingUtil.inflate<ItemRecyclerViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_recycler_view,
            parent,
            false
        )
        return AdvertViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdvertViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class AdvertViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarResponse) {
            binding.apply {
                this.item = item
            }
        }
    }

    companion object {
        private val diffUtilCallBack =
            object : DiffUtil.ItemCallback<CarResponse>() {
                override fun areItemsTheSame(oldItem: CarResponse, newItem: CarResponse): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(
                    oldItem: CarResponse,
                    newItem: CarResponse
                ): Boolean {
                    return oldItem.title == newItem.title && oldItem.id == newItem.id
                }
            }
    }
}