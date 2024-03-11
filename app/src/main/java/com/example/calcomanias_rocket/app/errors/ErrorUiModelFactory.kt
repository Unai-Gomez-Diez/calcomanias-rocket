package com.example.calcomanias_rocket.app.errors

class ErrorUiModelFactory {
    fun create(errorApp: ErrorApp, onClick: (() -> Unit)? = null): ErrorUiModel {
        return when (errorApp) {
            ErrorApp.DatabaseErrorApp -> DatabaseErrorUiModel(onClick)
            ErrorApp.InternetErrorApp -> InternetErrorUiModel(onClick)
            ErrorApp.UnknowErrorApp -> UnknowErrorUiModel(onClick)
            ErrorApp.ServerErrorApp -> ServerErrorUiModel(onClick)
            ErrorApp.ResourceNotFoundErrorApp -> ResourceNotFoundErrorUiModel(onClick)
        }
    }
}