package com.mamon.nestednavcompose.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mamon.nestednavcompose.ui.nav_graph.utils.TabSaver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tapSaver: TabSaver
): ViewModel(){

    private val _currentTapPosition = MutableStateFlow(tapSaver.fetchTabPosition())
    val currentTapPosition = _currentTapPosition.asStateFlow()


    init {
        _currentTapPosition.onEach {
            tapSaver.storeTabPosition(it)
        }.launchIn(viewModelScope)
    }

    // this function will save the last tab position
    fun updateTabPosition(position: Int) {
        _currentTapPosition.value = position
    }

}