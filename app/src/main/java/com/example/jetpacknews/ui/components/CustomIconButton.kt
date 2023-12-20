package com.example.jetpacknews.ui.components

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.ui.theme.Grey80
import com.example.jetpacknews.ui.theme.WhiteF4

@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @DrawableRes icon: Int,
    @ColorRes backgroundColor: Color = WhiteF4,
    @ColorRes textColor: Color = Grey80,
    @ColorRes iconColor: Color = Color.Unspecified
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "icon", tint = iconColor)
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = text),
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.W600
        )
    }
}