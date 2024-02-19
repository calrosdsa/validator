package app.validator.presentation.screens.home

import app.validator.data.providers.AppData

data class HomeState(
    val apps:List<AppData> = emptyList(),
    val title:String = ""
) {
    companion object{
        val Empty = HomeState()
    }
}