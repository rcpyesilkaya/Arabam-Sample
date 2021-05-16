package com.example.arabam_sample.ui.advert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.arabam_sample.R
import com.example.arabam_sample.data.remote.datasource.model.SortModel
import com.example.arabam_sample.databinding.FragmentAdvertListBinding
import com.example.arabam_sample.ui.advert.adapter.AdvertListAdapter
import com.example.arabam_sample.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdvertListFragment : Fragment() {

    private val advertListViewModel: AdvertListViewModel by viewModels()
    private val advertAdapter = AdvertListAdapter()
    private lateinit var binding: FragmentAdvertListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_advert_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        initRecyclerView()
        val sort = SortModel(1, 0)
        advertListViewModel.loadList(sort)
    }

    private fun initRecyclerView() {
        binding.rvCars.adapter = advertAdapter
    }

    private fun initLiveData() {
        advertListViewModel.advertListLiveData.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    with(binding) {
                        rvCars.visibility = View.VISIBLE
                        pbLoading.visibility = View.GONE
                        tvError.visibility = View.GONE
                    }
                    resource.data?.let { advertAdapter.submitList(it) }
                }
                is Resource.Loading -> {
                    with(binding) {
                        pbLoading.visibility = View.VISIBLE
                        tvError.visibility = View.GONE
                        rvCars.visibility = View.GONE
                    }
                }
                is Resource.Failed -> {
                    with(binding) {
                        pbLoading.visibility = View.GONE
                        tvError.visibility = View.VISIBLE
                        rvCars.visibility = View.GONE
                    }
                }
            }
        }
    }
}