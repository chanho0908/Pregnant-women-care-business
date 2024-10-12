package com.example.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.component.CircularIndicator
import com.example.presentation.component.KaKaoLoginButton
import com.example.presentation.component.NaverLoginButton
import com.example.presentation.theme.SampleTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToMain: () -> Unit
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is LoginSideEffect.Loading -> {
                isLoading = true
            }

            is LoginSideEffect.Success -> {
                navigateToMain()
            }

            is LoginSideEffect.Failure -> {
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    SampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween, // 위 아래로 공간을 채움
                horizontalAlignment = Alignment.CenterHorizontally // 중앙 정렬
            ) {
                if (isLoading) {
                    CircularIndicator()
                }

                Text(
                    text = "안녕하세요!\n간편 로그인을 진행해주세요!",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 120.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                KaKaoLoginButton(
                    onSuccess = { accessToken, idToken ->
                        viewModel.onCompleteLogIn(accessToken, idToken)
                    },
                    onFailure = {
                        viewModel.onFailLogIn("로그인에 실패했습니다.")
                    },
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                NaverLoginButton(
                    onSuccess = { accessToken, idToken ->
                        viewModel.onCompleteLogIn(accessToken, idToken)
                    },
                    onFailure = {
                        viewModel.onFailLogIn("로그인에 실패했습니다.")
                    },
                )
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navigateToMain = {})
}