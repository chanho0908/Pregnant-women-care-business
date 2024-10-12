package com.example.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(), ContainerHost<LoginState, LoginSideEffect> {
    override val container: Container<LoginState, LoginSideEffect> = container(
        initialState = LoginState(),
        buildSettings = {}
    )

    fun onCompleteLogIn(accessToken: String, idToken: String) = intent{
        Log.d("LoginViewModel", "accessToken: $accessToken, idToken: $idToken")
        postSideEffect(LoginSideEffect.Success)
    }

    fun onFailLogIn(msg: String) = intent{
        postSideEffect(LoginSideEffect.Failure(msg))
    }
}



