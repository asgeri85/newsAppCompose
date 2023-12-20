package com.example.jetpacknews.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.jetpacknews.ui.theme.BlueF2

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onChange: (String) -> Unit,
    @StringRes label: Int,
    action: ImeAction = ImeAction.Default,
    type: KeyboardType = KeyboardType.Text,
    @StringRes errorText: Int? = null,
    isError: Boolean = false,
) {
    OutlinedTextField(
        value = text,
        onValueChange = onChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = stringResource(id = label))
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = BlueF2,
            cursorColor = BlueF2,
            focusedBorderColor = BlueF2,
            disabledBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = action,
            keyboardType = type
        ),
    )
}