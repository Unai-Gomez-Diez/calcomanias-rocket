package com.example.calcomanias_rocket.feature.decals.domain

import com.example.calcomanias_rocket.app.domain.Either
import com.example.calcomanias_rocket.app.errors.ErrorApp

class SetDecalUseCase(private val repository: DecalRepository) {
    suspend operator fun invoke(decal: Decal): Either<ErrorApp, Boolean> = repository.setDecalUseCase(decal)
}