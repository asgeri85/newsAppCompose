package com.example.jetpacknews.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpacknews.R
import com.example.jetpacknews.domain.OnboardingUiModel
import com.example.jetpacknews.ui.components.CustomButton
import com.example.jetpacknews.ui.theme.BlueF2
import com.example.jetpacknews.ui.theme.GreyB8
import com.example.jetpacknews.ui.theme.GreyBD
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel()
) {

    val imageList = listOf(
        OnboardingUiModel(R.drawable.onb_1, R.string.onb1_title, R.string.onb1_desc),
        OnboardingUiModel(R.drawable.onb_2, R.string.onb1_title, R.string.onb1_desc),
        OnboardingUiModel(R.drawable.onb_3, R.string.onb1_title, R.string.onb1_desc)
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        imageList.size
    }

    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf(null, R.string.next)
                1 -> listOf(R.string.back, R.string.next)
                else -> listOf(R.string.back, R.string.get_started)
            }
        }
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f),
            state = pagerState,
            pageContent = {
                OnboardingItem(onboardingUiModel = imageList[it])
            }
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)
                .padding(horizontal = 24.dp)
                .navigationBarsPadding(),
            verticalAlignment = Alignment.Bottom,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    repeat(imageList.size) {
                        val color = if (pagerState.currentPage == it) BlueF2 else GreyBD
                        Box(
                            modifier = Modifier
                                .padding(3.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(16.dp)
                        )
                    }
                }
                Row {
                    buttonState.value[0]?.let {
                        TextButton(
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                                }
                            }, colors = ButtonDefaults.textButtonColors(
                                contentColor = GreyB8
                            )
                        ) {
                            Text(
                                text = stringResource(id = it),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    buttonState.value[1]?.let {
                        CustomButton(title = it) {
                            if (pagerState.currentPage == 2) {
                                viewModel.setEvent(OnboardingEvent.OnboardingComplete)

                            } else {
                                scope.launch {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun SplashPreview() {
    OnboardingScreen()
}