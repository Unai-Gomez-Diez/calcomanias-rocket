package com.example.calcomanias_rocket.feature.decals.domain

import com.example.calcomanias_rocket.feature.decals.app.domain.Either
import com.example.calcomanias_rocket.feature.decals.app.errors.ErrorApp

class GetDecalUseCase(private val repository: DecalRepository) {
    suspend operator fun invoke(id: String): Either<ErrorApp, Decal>{
        return repository.getDecalUseCase(id)
    }
}