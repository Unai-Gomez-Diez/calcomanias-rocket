package com.example.calcomanias_rocket.feature.decals.domain

import com.example.calcomanias_rocket.feature.decals.app.domain.Either
import com.example.calcomanias_rocket.feature.decals.app.errors.ErrorApp

class GetDecalsUseCase(private val repository: DecalRepository) {
    suspend operator fun invoke(): Either<ErrorApp, List<Decal>>{
        return repository.getDecalsUseCase()
    }
}