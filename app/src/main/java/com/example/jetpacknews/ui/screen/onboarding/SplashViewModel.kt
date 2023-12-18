package com.example.jetpacknews.ui.screen.onboarding

import androidx.lifecycle.viewModelScope
import com.example.jetpacknews.common.NetworkConnectivityObserver
import com.example.jetpacknews.common.base.BaseViewModel
import com.example.jetpacknews.common.base.Effect
import com.example.jetpacknews.common.base.Event
import com.example.jetpacknews.common.base.State
import com.example.jetpacknews.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val networkConnectivityObserver: NetworkConnectivityObserver
) : BaseViewModel<SplashUiState, SplashEvent, SplashEffect>() {

    override fun setInitialState(): SplashUiState = SplashUiState()

    override fun handleEvent(event: SplashEvent) {

    }

    init {
        checkNetworkConnection()
    }

    private fun checkNetworkConnection() {
        viewModelScope.launch {
            val isConnection = networkConnectivityObserver.isNetworkAvailable()
            setState(SplashUiState(networkStatus = isConnection))
            if (isConnection) {
                getOnboardingCase()
            }
        }
    }

    private fun getOnboardingCase() {
        viewModelScope.launch {
            dataStoreRepository.getOnboardState.collectLatest {
                setState(getCurrentState().copy(isComplete = it ?: false))
            }
        }
    }
}

data class SplashUiState(
    val isComplete: Boolean = false,
    val networkStatus: Boolean = false
) : State

sealed interface SplashEffect : Effect

sealed interface SplashEvent : Event