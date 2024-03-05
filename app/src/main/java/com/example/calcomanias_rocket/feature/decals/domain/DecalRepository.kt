package com.example.calcomanias_rocket.feature.decals.domain

import com.example.calcomanias_rocket.feature.decals.app.domain.Either
import com.example.calcomanias_rocket.feature.decals.app.errors.ErrorApp

interface DecalRepository {
    suspend fun getDecalsUseCase(): Either<ErrorApp, List<Decal>>

    suspend fun getDecalUseCase(id: String): Either<ErrorApp, Decal>

    suspend fun setDecalUseCase(decal: Decal): Either<ErrorApp, Boolean>
}