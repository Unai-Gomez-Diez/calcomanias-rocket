package com.example.calcomanias_rocket.feature.decals.domain

import com.example.calcomanias_rocket.app.domain.Either
import com.example.calcomanias_rocket.app.errors.ErrorApp

interface DecalRepository {
    suspend fun getDecalsUseCase(): Either<ErrorApp, List<Decal>>

    suspend fun getDecalUseCase(id: String): Either<ErrorApp, Decal>


}