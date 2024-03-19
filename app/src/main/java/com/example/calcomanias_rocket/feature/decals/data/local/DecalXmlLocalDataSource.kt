package com.example.calcomanias_rocket.feature.decals.data.local

import android.content.Context
import com.example.calcomanias_rocket.app.domain.Either
import com.example.calcomanias_rocket.app.domain.left
import com.example.calcomanias_rocket.app.domain.right
import com.example.calcomanias_rocket.app.errors.ErrorApp
import com.example.calcomanias_rocket.app.serialization.JsonSerialization
import com.example.calcomanias_rocket.feature.decals.domain.Decal

class DecalXmlLocalDataSource(
    private val context: Context?,
    private val jsonSerialization: JsonSerialization
): DecalLocalDataSource {
    private val sharedPref = context?.getSharedPreferences("Decals", Context.MODE_PRIVATE)
    override fun setDecals(decals: List<Decal>): Either<ErrorApp, List<Decal>> {
        return try {
            decals.map { decals->
                sharedPref?.edit()?.putString(
                    decals.id,
                    jsonSerialization.toJson(decals, Decal::class.java)
                )
            }
            sharedPref?.edit()?.apply()
            decals.right()
        }catch (e: Exception){
            return ErrorApp.DatabaseErrorApp.left()
        }
    }

    override fun getDecal(id: String): Either<ErrorApp, Decal> {
        return try {
            val mapDecal = sharedPref?.all as Map<String, String>
            val decal = mapDecal.values.map {
                jsonSerialization.fromJson(it, Decal::class.java)
            }.find { decal ->
                decal.id == id
            }!!
            decal.right()
        }catch (e: Exception){
            ErrorApp.DatabaseErrorApp.left()
        }
    }

    override fun getDecals(): Either<ErrorApp, List<Decal>> {
        return try {
            val decals: MutableList<Decal> = mutableListOf()
            val mapDecal = sharedPref?.all as Map<String, String>
            mapDecal.values.map {string->
                decals.add(jsonSerialization.fromJson(string, Decal::class.java))
            }
            decals.right()
        }catch (e: Exception){
            ErrorApp.DatabaseErrorApp.left()
        }
    }
}