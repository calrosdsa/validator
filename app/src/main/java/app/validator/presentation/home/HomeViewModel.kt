package app.validator.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.validator.data.providers.AppData
import app.validator.data.providers.AppDataProvider
import app.validator.di.AnalyticsService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

data class DiceUiState(
    val firstDieValue: Int? = null,
    val secondDieValue: Int? = null,
    val numberOfRolls: Int = 0,
)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val analyticsService: AnalyticsService
//    private val appDataProvider: AppDataProvider
):ViewModel() {
    val appsState = MutableStateFlow<List<AppData>>(emptyList())
    private val  title = MutableStateFlow("Title")
    val state: StateFlow<HomeState> = combine(
        appsState,
        title
    ){apps,title->
        HomeState(
            apps = apps,
            title = title
        )
    }.stateIn(
        scope =  viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeState.Empty
    )

    init {
//        viewModelScope.launch {
//            appDataProvider.fetchInstalledAppList().collect{
//                appsState.emit(it)
//                Log.d("DEBUG_APP_",it.toString())
//            }
//        }
    }

    fun updateTitle(){
        viewModelScope.launch {
            title.emit("New title")
        }
    }

    fun isActive():Boolean{
        return analyticsService.isActive()
    }

//    fun getDataString():String{
//        return appDataProvider.testFunction()
//    }
}