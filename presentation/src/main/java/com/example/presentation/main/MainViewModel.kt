package com.example.presentation.main

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMaternityStoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMaternityStoreUseCase: GetMaternityStoreUseCase,
): ViewModel(), ContainerHost<MainState, MainSideEffect> {
    override val container: Container<MainState, MainSideEffect> = container(
        initialState = MainState(),
    )

    init {
        viewModelScope.launch {
            getMaternityStoreUseCase().onSuccess { maternityStoreList ->
                Log.d("dasdasdsa", maternityStoreList.toString())
            }.onFailure {
                Log.d("dasdasdsa", it.toString())

            }
        }
    }
}

@Immutable
data class MainState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

sealed class MainSideEffect {
    data class ShowToast(val message: String): MainSideEffect()
    object NavigateToDetail: MainSideEffect()
}


