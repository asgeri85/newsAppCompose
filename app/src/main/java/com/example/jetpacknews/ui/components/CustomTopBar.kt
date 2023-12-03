package com.example.jetpacknews.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.R

@Composable
fun CustomTopBar(modifier: Modifier = Modifier, @StringRes title: Int) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        IconButton(onClick = {

        }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "arrowLeft"
            )
        }
        Text(
            text = stringResource(id = title),
            color = Color.Black,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        IconButton(onClick = {

        }, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu")
        }
    }
}