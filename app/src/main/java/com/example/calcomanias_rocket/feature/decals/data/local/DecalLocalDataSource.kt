package com.example.calcomanias_rocket.feature.decals.data.local

import com.example.calcomanias_rocket.app.domain.Either
import com.example.calcomanias_rocket.app.errors.ErrorApp
import com.example.calcomanias_rocket.feature.decals.domain.Decal

interface DecalLocalDataSource {
    fun setDecals(decals: List<Decal>): Either<ErrorApp, List<Decal>>
    fun getDecal(id: String):Either<ErrorApp, Decal>
    fun getDecals(): Either<ErrorApp, List<Decal>>
}