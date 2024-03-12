package com.example.calcomanias_rocket.feature.decals.presentation

import androidx.fragment.app.Fragment
import com.example.calcomanias_rocket.databinding.FragmentDecalsBinding
import com.example.calcomanias_rocket.feature.decals.presentation.Adapter.DecalsAdapter

class DecalsFragment: Fragment() {

    private var _binding: FragmentDecalsBinding? = null
    private val binding get() = _binding!!
    private val decalsAdapter = DecalsAdapter()

}