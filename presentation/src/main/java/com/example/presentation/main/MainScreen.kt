package com.example.presentation.main

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.theme.SampleTheme
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.collectAsState().value

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