package com.example.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.utils.Utils
import com.example.presentation.theme.SampleTheme
import com.kakao.sdk.common.util.Utility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sadcxs", "keyhash : ${Utility.getKeyHash(this)}")
        setContent {
            SampleTheme{
                MainScreen()
            }
        }
    }
}
