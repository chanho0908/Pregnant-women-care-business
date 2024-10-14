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
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMaternityStoreUseCase: GetMaternityStoreUseCase,
): ViewModel(), ContainerHost<MainStates, MainSideEffect> {
    override val container: Container<MainStates, MainSideEffect> = container(
        initialState = MainStates(emptyList()),
    )

    init {
        load()
    }

    private fun load() = intent{
        postSideEffect(MainSideEffect.Loading)

        getMaternityStoreUseCase().onSuccess { maternityStores ->
            reduce { state.copy( stores =  maternityStores.toUiModel() ) }
        }.onFailure {
            postSideEffect(MainSideEffect.Toast("데이터 로딩에 실패 했습니다."))
        }
    }
}

sealed class MainSideEffect {
    data object Loading: MainSideEffect()
    data class Toast(val message: String): MainSideEffect()
    object NavigateToDetail: MainSideEffect()
}


