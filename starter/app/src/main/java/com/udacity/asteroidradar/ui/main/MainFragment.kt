package com.udacity.asteroidradar.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
//        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        viewModel.getAllPicturesOfToday().observe(viewLifecycleOwner) {
            if (it != null) {
                if (it.mediaType == "image") {
                    val picasso = Picasso.get()
                    picasso.load(it.url).into(binding.activityMainImageOfTheDay)
                } else {
                    //not image

                }

            } else {
                // no data exists
            }
        }




        viewModel.fetchAllPicturesOfToday()


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}
