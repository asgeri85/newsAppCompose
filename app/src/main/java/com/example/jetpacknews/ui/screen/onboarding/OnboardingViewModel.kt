package com.example.jetpacknews.ui.screen.onboarding

import androidx.lifecycle.viewModelScope
import com.example.jetpacknews.common.base.BaseViewModel
import com.example.jetpacknews.common.base.Effect
import com.example.jetpacknews.common.base.Event
import com.example.jetpacknews.common.base.State
import com.example.jetpacknews.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : BaseViewModel<OnboardingUiState, OnboardingEvent, OnboardingEffect>() {

    override fun setInitialState(): OnboardingUiState = OnboardingUiState()

    override fun handleEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.OnboardingComplete -> {
                setOnboardingCase()
            }
        }
    }

    private fun setOnboardingCase() {
        viewModelScope.launch {
            dataStoreRepository.setOnboardState()
        }
    }

}

data class OnboardingUiState(
    val isComplete: Boolean = false
) : State

sealed interface OnboardingEffect : Effect

sealed interface OnboardingEvent : Event {

    object OnboardingComplete : OnboardingEvent

}
