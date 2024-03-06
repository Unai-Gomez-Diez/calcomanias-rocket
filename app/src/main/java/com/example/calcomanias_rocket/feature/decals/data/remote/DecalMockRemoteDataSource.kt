package com.example.calcomanias_rocket.feature.decals.data.remote

import com.example.calcomanias_rocket.feature.decals.domain.Decal

class DecalMockRemoteDataSource {
    private val decalMock: List<Decal> = listOf(
        Decal("0","Africa","Decal Animada hecha a Africa","https://wallpaperaccess.com/full/4923423.jpg"),
        Decal("1","Kyrex","Decal Animada hecha a Kyrex","https://wallpaperaccess.com/full/4923423.jpg"),
        Decal("2","Lady","Decal Animada hecha a Lady","https://wallpaperaccess.com/full/4923423.jpg"),
        Decal("3","Stake","Decal Animada hecha a Stake","https://wallpaperaccess.com/full/4923423.jpg")

    )
    fun getDecals(): List<Decal> = decalMock
}