package com.example.arabam_sample.ui.advert.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arabam_sample.R
import com.example.arabam_sample.data.remote.datasource.model.CarResponse
import com.example.arabam_sample.databinding.ItemRecyclerViewBinding

class AdvertListAdapter : RecyclerView.Adapter<AdvertListAdapter.AdvertViewHolder>() {

    private var advertList: List<CarResponse> = arrayListOf()

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
        holder.bind(advertList[position])
    }

    override fun getItemCount(): Int = advertList.size

    fun submitList(newAdvertList: List<CarResponse>) {
        advertList = newAdvertList
        notifyDataSetChanged()
    }

    class AdvertViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarResponse) {
            binding.apply {
                this.item = item
            }
        }
    }
}