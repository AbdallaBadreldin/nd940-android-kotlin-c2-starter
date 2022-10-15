package com.udacity.asteroidradar.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.getAllAsteroids().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerView = binding.asteroidRecycler
                recyclerViewAdapter = RecyclerViewAdapter(it)
                recyclerView.adapter = recyclerViewAdapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            } else {
                // no data exists
            }
        }
        setHasOptionsMenu(true)

        if (viewModel.isNetworkAvailable(context)) {
            viewModel.fetchAllPicturesOfToday()
            viewModel.fetchAllAsteroids()
        }

        showDataOfPicOfToday()
        return binding.root
    }

    private fun showDataOfPicOfToday() {
        viewModel.getAllPicturesOfToday().observe(viewLifecycleOwner) {
            if (it != null) {
                if (it.mediaType == "image") {
                    val picasso = Picasso.get()
                    picasso.load(it.url).into(binding.activityMainImageOfTheDay)
                    binding.activityMainImageOfTheDay.contentDescription = it.title
                    binding.textView.text = it.title
                } else {
                    //not image
                }
            } else {
                // no data exists
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.show_week_menu) {
            showWeekData()
            return true
        }
        if (item.itemId == R.id.show_today_menu) {
            showTodayData()
            return true
        }
        if (item.itemId == R.id.show_all_menu) {
            showAllData()
            return true
        }

        return false
    }

    fun showAllData() {
        viewModel.getAllAsteroids().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerView.Recycler().clear()
                recyclerViewAdapter.submitData(it)
            } else {
                // no data exists
            }
        }
    }

    fun showWeekData() {
        viewModel.getTodayAsteroidData().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerViewAdapter.submitData(it)
            } else {
                // no data exists

            }
        }
    }

    fun showTodayData() {
        viewModel.getTodayAsteroidData().observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerViewAdapter.submitData(it)
            } else {
                // no data exists

            }
        }
    }
}
