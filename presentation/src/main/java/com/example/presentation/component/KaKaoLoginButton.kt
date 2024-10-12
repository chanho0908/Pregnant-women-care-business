package com.example.presentation.component

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Grey95
import com.example.presentation.theme.KakaoYellow
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.auth.model.OAuthToken

@Composable
fun KaKaoLoginButton(
    onSuccess: (accessToken: String, idToken: String) -> Unit,
    onFailure: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    TextButton(
        onClick = {
            val kakaoInstance = UserApiClient.instance
            val available = kakaoInstance.isKakaoTalkLoginAvailable(context)
            val loginCallback = { token: OAuthToken?, error: Throwable? ->
                Log.d("dasdadsadas", error.toString())
                if (error != null) {
                    onFailure()
                } else if (token != null) {
                    onSuccess(token.accessToken, token.idToken!!)
                }
            }

            if (available) {
                kakaoInstance.loginWithKakaoTalk(context, callback = loginCallback)
            } else {
                kakaoInstance.loginWithKakaoAccount(context, callback = loginCallback)
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = KakaoYellow),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart,
        ) {
            Icon(
                // 페인터는 리컴포지션이 일어날 수 있다
                // imageVector는 immutable해서  리컴포지션이 일어나지 않는다
                imageVector = ImageVector.vectorResource(R.drawable.ic_kakao),
                contentDescription = stringResource(R.string.login_with_kakaotalk),
                modifier = Modifier.size(width = 20.dp, height = 20.dp),
                tint = Color.Black,
            )

            Text(
                stringResource(R.string.login_with_kakaotalk),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                color = Grey95,
                textAlign = TextAlign.Center,
            )
        }
    }
}