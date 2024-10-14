package com.example.presentation.main

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.theme.SampleTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.collectAsState().value

    var progressBarVisible by remember { mutableStateOf(false) }

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect){
            is MainSideEffect.Loading -> {
                progressBarVisible = true
            }
            is MainSideEffect.Toast -> {
                progressBarVisible = false
            }
            is MainSideEffect.NavigateToDetail -> {

            }
        }
    }

    SampleTheme {
        Surface {
            Text(state.toString())
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}