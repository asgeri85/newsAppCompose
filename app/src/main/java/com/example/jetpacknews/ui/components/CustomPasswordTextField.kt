package com.example.jetpacknews.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.theme.BlueF2

@Composable
fun CustomPasswordTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    action: ImeAction = ImeAction.Default,
    isError: Boolean = false
) {

    val passwordVisibility = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        label = {
            Text(text = stringResource(id = label))
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = action
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedLabelColor = BlueF2,
            cursorColor = BlueF2,
            focusedBorderColor = BlueF2,
            disabledBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black
        ),
        modifier = modifier.fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {
                Icon(
                    painter = painterResource(
                        id = if (!passwordVisibility.value) {
                            R.drawable.visibility
                        } else {
                            R.drawable.visibility_off
                        }
                    ),
                    contentDescription = "icon",
                )
            }
        },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = isError
    )
}