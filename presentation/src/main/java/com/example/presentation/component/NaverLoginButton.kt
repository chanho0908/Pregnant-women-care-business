package com.example.presentation.component

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.naverGreen
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import timber.log.Timber

@Composable
fun NaverLoginButton(
    onSuccess: (accessToken: String, idToken: String) -> Unit,
    onFailure: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    TextButton(
        onClick = {
            NaverIdLoginSDK.authenticate(context, object : OAuthLoginCallback {
                override fun onSuccess() {

                    val accessToken = NaverIdLoginSDK.getAccessToken()
                    val refreshToken = NaverIdLoginSDK.getRefreshToken()

                    if (accessToken != null && refreshToken != null) {
                        onSuccess(accessToken, refreshToken)
                    }
                }

                override fun onFailure(httpStatus: Int, message: String) {
                    // 로그인 실패
                    val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                    val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                    onFailure()
                    Timber.e("$errorCode : $errorDescription")
                }

                override fun onError(errorCode: Int, message: String) {
                    // 로그인 중 오류 발생
                    onFailure()
                    onFailure(errorCode, message)
                }
            })
        },
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = naverGreen),
        contentPadding = PaddingValues(horizontal = 20.dp)

    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_naver),
                contentDescription = stringResource(R.string.login_with_naver),
                modifier = Modifier.size(width = 20.dp, height = 20.dp),
                tint = Color.White
            )

            Text(
                text = stringResource(R.string.login_with_naver),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun NaverLoginButtonPreview() {
    NaverLoginButton(
        onSuccess = { accessToken, idToken -> },
        onFailure = {},
        modifier = Modifier
    )
}