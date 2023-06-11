package com.capstoneproject.kukuku.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstoneproject.kukuku.data.ArticleRepository
import com.capstoneproject.kukuku.model.ArticleList
import com.capstoneproject.kukuku.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: ArticleRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<ArticleList>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<ArticleList>>
        get() = _uiState

    fun getById(phoneId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getById(phoneId))
        }
    }
}