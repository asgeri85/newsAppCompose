package com.example.jetpacknews.ui.components

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.ui.theme.BlueF2

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @ColorRes titleColor: Color = Color.White,
    @ColorRes backgroundColor: Color = BlueF2,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor, contentColor = titleColor
        ),
        contentPadding = PaddingValues(vertical = 14.dp, horizontal = 24.dp),
        modifier = modifier,
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(text = stringResource(id = title), fontSize = 16.sp, fontWeight = FontWeight.W600)
    }
}