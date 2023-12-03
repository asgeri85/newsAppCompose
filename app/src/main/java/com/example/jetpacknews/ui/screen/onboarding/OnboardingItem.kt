package com.example.jetpacknews.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.domain.OnboardingUiModel
import com.example.jetpacknews.ui.theme.Black66

@Composable
fun OnboardingItem(modifier: Modifier = Modifier, onboardingUiModel: OnboardingUiModel) {
    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = onboardingUiModel.image),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 24.dp)) {
            Text(
                text = stringResource(id = onboardingUiModel.title),
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = stringResource(id = onboardingUiModel.description),
                fontSize = 16.sp,
                color = Black66
            )
        }
    }
}