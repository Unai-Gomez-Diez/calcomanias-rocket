package com.example.calcomanias_rocket.app.serialization

interface JsonSerialization {
    fun <T> toJson(obj: T, typeClass: Class<T>): String

    fun <T> fromJson(json: String, typeClass: Class<T>): T
}