package com.example.calcomanias_rocket.feature.decals.data

import android.content.Context
import com.example.calcomanias_rocket.app.domain.Either
import com.example.calcomanias_rocket.app.domain.left
import com.example.calcomanias_rocket.app.domain.right
import com.example.calcomanias_rocket.app.errors.ErrorApp
import com.example.calcomanias_rocket.app.serialization.JsonSerialization
import com.example.calcomanias_rocket.feature.decals.data.local.DecalLocalDataSource
import com.example.calcomanias_rocket.feature.decals.data.local.DecalXmlLocalDataSource
import com.example.calcomanias_rocket.feature.decals.data.remote.DecalMockRemoteDataSource
import com.example.calcomanias_rocket.feature.decals.domain.Decal
import com.example.calcomanias_rocket.feature.decals.domain.DecalRepository

class DecalDataRepository(
    private val decalXmlLocalDataSource: DecalLocalDataSource,
    private val decalMockRemoteDataSource: DecalMockRemoteDataSource
): DecalRepository {
    override suspend fun getDecalsUseCase(): Either<ErrorApp, List<Decal>> {
        val decalsList = decalXmlLocalDataSource.getDecals()
        return if (decalsList.isLeft() || decalsList.get().isEmpty()){
            decalMockRemoteDataSource.getDecals().map {
                decalXmlLocalDataSource.setDecals(listOf(it))
                it
            }.right()
        }else{
            decalsList
        }
    }

    override suspend fun getDecalUseCase(id: String): Either<ErrorApp, Decal> {
        val decalsList = decalXmlLocalDataSource.getDecals()
        return decalsList.get().find {
            it.id == id
        }!!.right()
    }



}