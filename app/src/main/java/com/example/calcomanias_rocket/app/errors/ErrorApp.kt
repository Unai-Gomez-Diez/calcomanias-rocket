package com.example.calcomanias_rocket.app.errors

sealed class ErrorApp {
    object InternetErrorApp : ErrorApp()
    object DatabaseErrorApp : ErrorApp()
    object UnknowErrorApp : ErrorApp()
    object ServerErrorApp : ErrorApp()
    object ResourceNotFoundErrorApp : ErrorApp()
}