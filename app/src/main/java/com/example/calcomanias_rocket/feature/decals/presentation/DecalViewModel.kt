package com.example.calcomanias_rocket.feature.decals.presentation

import androidx.lifecycle.ViewModel
import com.example.calcomanias_rocket.app.errors.ErrorUiModel
import com.example.calcomanias_rocket.feature.decals.domain.Decal
import com.example.calcomanias_rocket.feature.decals.domain.GetDecalUseCase

class DecalViewModel(private val getDecalUseCase: GetDecalUseCase)
    : ViewModel() {
    private val _
    data class uiStateDecal(
        val decal: Decal? = null,
        val error: ErrorUiModel? = null,
        val isLoading: Boolean = false
    )
}