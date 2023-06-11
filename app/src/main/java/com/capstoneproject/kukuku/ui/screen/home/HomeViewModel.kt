package com.capstoneproject.kukuku.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstoneproject.kukuku.data.ArticleRepository
import com.capstoneproject.kukuku.model.ArticleList
import com.capstoneproject.kukuku.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: ArticleRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<ArticleList>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<ArticleList>>>
        get() = _uiState

    fun getAllData() {
        viewModelScope.launch {
            repository.getAllData()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }

}