package com.example.jetpacknews.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.example.jetpacknews.common.base.BaseViewModel
import com.example.jetpacknews.common.base.Effect
import com.example.jetpacknews.common.base.Event
import com.example.jetpacknews.common.base.State
import com.example.jetpacknews.domain.model.ArticleUiModel
import com.example.jetpacknews.domain.useCase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : BaseViewModel<HomeUiState, HomeEvent, HomeEffect>() {

    override fun setInitialState(): HomeUiState = HomeUiState()

    override fun handleEvent(event: HomeEvent) {

    }

    init {
        getTopNews()
    }

    private fun getTopNews() {
        viewModelScope.launch {
            homeUseCase.getTopNews("us").handleResult(onComplete = {
                setState(HomeUiState(isLoading = false, topNews = it))
            }, onError = {
                setEffect(HomeEffect.ShowHomeError(it.message ?: "Error 404"))
                setState(HomeUiState(isLoading = false, isError = true))
            }, onLoading = {
                setState(HomeUiState(isLoading = true))
            })
        }
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val topNews: List<ArticleUiModel> = emptyList(),
    val isError: Boolean = false
) : State

sealed interface HomeEffect : Effect {
    data class ShowHomeError(val message: String) : HomeEffect

}

sealed interface HomeEvent : Event {

}