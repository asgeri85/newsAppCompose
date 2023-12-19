package com.example.jetpacknews.ui.screen.onboarding

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.components.LoadingLottie
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateHome: () -> Unit,
    navigateOnboarding: () -> Unit
) {

    val activity = (LocalContext.current as? Activity)
    val state = viewModel.state.collectAsStateWithLifecycle()
    val dialogOpen = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = state.value.networkStatus) {
        delay(2500)
        if (state.value.networkStatus) {
            if (state.value.isComplete) {
                navigateHome.invoke()
            } else {
                navigateOnboarding.invoke()
            }
        } else {
            dialogOpen.value = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (dialogOpen.value) {
            AlertDialog(onDismissRequest = {
                dialogOpen.value = false
            }, confirmButton = {
                TextButton(onClick = {
                    dialogOpen.value = false
                    activity?.finish()
                }) {
                    Text(text = stringResource(id = R.string.ok))
                }
            }, title = {
                Text(text = stringResource(id = R.string.network_error))
            }, text = {
                Text(text = stringResource(id = R.string.network_error_subtitle))
            })
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .height(70.dp)
                .width(220.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        LoadingLottie(isLoading = true, modifier = Modifier.size(150.dp))
    }
}
