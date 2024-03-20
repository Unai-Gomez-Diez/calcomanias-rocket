package com.example.calcomanias_rocket.feature.decals.presentation

import DecalsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.calcomanias_rocket.app.errors.ErrorUiModel
import com.example.calcomanias_rocket.app.serialization.GsonSerialization
import com.example.calcomanias_rocket.databinding.FragmentDecalsBinding
import com.example.calcomanias_rocket.feature.decals.data.DecalDataRepository
import com.example.calcomanias_rocket.feature.decals.data.local.DecalXmlLocalDataSource
import com.example.calcomanias_rocket.feature.decals.data.remote.DecalMockRemoteDataSource
import com.example.calcomanias_rocket.feature.decals.domain.GetDecalsUseCase
import com.google.gson.Gson

class DecalsFragment : Fragment() {

    private var _binding: FragmentDecalsBinding? = null
    private val binding get() = _binding!!
    private val decalsAdapter = DecalsAdapter()


    private val viewModel: DecalsViewModel by lazy {
        DecalsViewModel(
            GetDecalsUseCase(DecalDataRepository(
                DecalXmlLocalDataSource(context, GsonSerialization(Gson())),
                DecalMockRemoteDataSource()
            ))
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDecalsBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDecals()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupView() {
        binding.recyclerView.apply {
            adapter = decalsAdapter
        }
    }

    private fun setupObserver() {
        val observer = Observer<DecalsViewModel.DecalUiState> { state ->

            state.decals?.let {
                decalsAdapter.submitList(it)
            }
        }
        viewModel.uiDecal.observe(viewLifecycleOwner, observer)
    }





}