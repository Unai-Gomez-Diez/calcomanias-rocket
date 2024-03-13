package com.example.calcomanias_rocket.feature.decals.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.calcomanias_rocket.app.errors.ErrorUiModel
import com.example.calcomanias_rocket.databinding.FragmentDecalsBinding
import com.example.calcomanias_rocket.feature.decals.presentation.Adapter.DecalsAdapter

class DecalsFragment: Fragment() {

    private var _binding: FragmentDecalsBinding? = null
    private val binding get() = _binding!!
    private val decalsAdapter = DecalsAdapter()
    val viewModel by viewModels<DecalsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDecalsBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    private fun setupView() {
        binding.apply {
            recyclerView.apply {
                decalsAdapter.setEvent {

                }
                adapter = decalsAdapter
            }
        }
    }

    private fun setupObserver(){
        val observer = Observer<DecalsViewModel.DecalUiState>{
            if (it.error != null){
                showError(it.error)
            }else{
                val listDecals = it.decals
                decalsAdapter.submitList(listDecals)
            }
        }
        viewModel.uiDecal.observe(viewLifecycleOwner, observer)
    }

    private fun showError(error: ErrorUiModel){
       // binding.errorView.
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}