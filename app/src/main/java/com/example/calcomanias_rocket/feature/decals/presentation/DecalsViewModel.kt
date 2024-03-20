package com.example.calcomanias_rocket.feature.decals.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calcomanias_rocket.app.errors.ErrorApp
import com.example.calcomanias_rocket.app.errors.ErrorUiModel
import com.example.calcomanias_rocket.feature.decals.domain.Decal
import com.example.calcomanias_rocket.feature.decals.domain.GetDecalsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DecalsViewModel(private val getDecalsUseCase: GetDecalsUseCase)
    : ViewModel() {
    private val _decalUiState = MutableLiveData<DecalUiState>()
    val uiDecal: LiveData<DecalUiState> = _decalUiState

    fun getDecals(){
        viewModelScope.launch(Dispatchers.IO){
            getDecalsUseCase().fold(
                {responseError(it)},
                {responseGetDecals(it)}
            )
        }
    }

        private fun responseGetDecals(decals: List<Decal>){
            _decalUiState.postValue(
                DecalUiState(decals = decals)
            )
        }
        private fun responseError(errorApp:ErrorApp)=
            _decalUiState.postValue(DecalUiState(error = errorApp.toErrorUi()))
        data class DecalUiState(
            val error: ErrorUiModel?= null,
            val isLoading: Boolean = false,
            val decals: List<Decal>?=null
        )
}