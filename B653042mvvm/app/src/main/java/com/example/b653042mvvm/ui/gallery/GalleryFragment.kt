package com.example.b6532mvvm.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.b653042mvvm.R

import com.example.b653042mvvm.ui.gallery.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint



class GalleryFragment: Fragment(R.layout.fragment_gallery) {
    private val viewModel by viewModel<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.photos.observe(viewLifecycleOwner){

        }
    }
}