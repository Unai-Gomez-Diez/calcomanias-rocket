package com.example.calcomanias_rocket.feature.decals.presentation

import com.example.calcomanias_rocket.app.errors.ErrorApp
import com.example.calcomanias_rocket.app.errors.ErrorUiModel
import com.example.calcomanias_rocket.app.errors.ErrorUiModelFactory

fun ErrorApp.toErrorUi(onClickRetry: (() -> Unit)? = null): ErrorUiModel {
    return ErrorUiModelFactory().create(this, onClickRetry)
}