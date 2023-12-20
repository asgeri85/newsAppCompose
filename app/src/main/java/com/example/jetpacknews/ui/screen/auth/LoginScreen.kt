package com.example.jetpacknews.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.components.CustomButton
import com.example.jetpacknews.ui.components.CustomIconButton
import com.example.jetpacknews.ui.components.CustomPasswordTextField
import com.example.jetpacknews.ui.components.CustomTextField
import com.example.jetpacknews.ui.theme.Black66
import com.example.jetpacknews.ui.theme.BlueF2
import com.example.jetpacknews.ui.theme.BlueFF
import com.example.jetpacknews.ui.theme.Grey80

@Composable
@Preview
fun LoginScreen() {

    val username = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val checkedRemember = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.hello),
            fontSize = 48.sp,
            color = Color.Black,
            fontWeight = FontWeight.W700
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.again),
            fontSize = 48.sp,
            color = BlueF2,
            fontWeight = FontWeight.W700
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = stringResource(id = R.string.welcome_back), fontSize = 20.sp, color = Black66)
        Spacer(modifier = Modifier.height(32.dp))

        CustomTextField(text = username.value, onChange = {
            username.value = it
        }, label = R.string.email, type = KeyboardType.Email, action = ImeAction.Next)
        Spacer(modifier = Modifier.height(16.dp))
        CustomPasswordTextField(text = password.value, onValueChange = {
            password.value = it
        }, label = R.string.password, action = ImeAction.Done)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = checkedRemember.value,
                    onCheckedChange = { checkedRemember.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueF2,
                        checkmarkColor = Color.White
                    ),
                    modifier = Modifier.padding(horizontal = 0.dp)
                )
                Text(text = stringResource(id = R.string.remember_me), color = Black66)
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.forgot_password), color = BlueFF)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(title = R.string.login, modifier = Modifier.fillMaxWidth()) {
            //todo login click≈
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.or_continue),
            color = Black66,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            CustomIconButton(
                text = R.string.facebook, icon = R.drawable.facebook, modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(24.dp))
            CustomIconButton(
                text = R.string.google, icon = R.drawable.google, modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.have_account), color = Grey80)
            TextButton(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
                    contentColor = BlueF2
                )
            ) {
                Text(text = stringResource(id = R.string.sign_up), fontWeight = FontWeight.W600)
            }
        }
    }
}