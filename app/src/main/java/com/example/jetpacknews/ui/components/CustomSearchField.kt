package com.example.jetpacknews.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.theme.GreyBD

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchField(
    text: String,
    onChangeText: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onChangeText.invoke(it) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "searchIcon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "settingIcon"
            )
        },
        shape = RoundedCornerShape(6.dp),
        placeholder = {
            Text(text = stringResource(id = R.string.search), color = GreyBD)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        modifier = Modifier.fillMaxWidth()
    )
}