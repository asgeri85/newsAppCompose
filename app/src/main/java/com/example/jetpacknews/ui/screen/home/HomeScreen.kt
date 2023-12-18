package com.example.jetpacknews.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jetpacknews.R
import com.example.jetpacknews.ui.components.CustomAsyncImage
import com.example.jetpacknews.ui.components.CustomSearchField
import com.example.jetpacknews.ui.screen.home.components.ItemHomeNews
import com.example.jetpacknews.ui.theme.Black66
import com.example.jetpacknews.ui.theme.GreyBD

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateTrend: () -> Unit
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    val searchText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.logo_s), contentDescription = "logo")
            FilledIconButton(
                onClick = { /*TODO*/ }, colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White, contentColor = Color.Black
                ), shape = RoundedCornerShape(6.dp),
                modifier = Modifier.shadow(elevation = 10.dp, shape = RoundedCornerShape(6.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ring),
                    contentDescription = "notification"
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        CustomSearchField(text = searchText.value, onChangeText = {
            searchText.value = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        if (state.value.topNews.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.trending),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W600
                )
                TextButton(
                    onClick = {
                        navigateTrend.invoke()
                    }, colors = ButtonDefaults.textButtonColors(
                        contentColor = Black66
                    )
                ) {
                    Text(text = stringResource(id = R.string.see_all))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                val dataCard = state.value.topNews[4]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.22f),
                    shape = RoundedCornerShape(6.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp
                    )
                ) {
                    CustomAsyncImage(
                        url = dataCard.image,
                        modifier = Modifier.fillMaxSize(),
                        scale = ContentScale.FillBounds
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "USA", fontSize = 13.sp, color = Black66)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = dataCard.title,
                    fontSize = 16.sp,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    CustomAsyncImage(
                        url = dataCard.source,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(100f),
                            )
                            .size(20.dp),
                        scale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = dataCard.sourceName,
                        fontSize = 13.sp,
                        color = Black66,
                        fontWeight = FontWeight.W600
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock),
                            contentDescription = "clock"
                        )
                        Text(
                            text =
                            if (dataCard.date == 0) stringResource(id = R.string.now) else stringResource(
                                id = R.string.hours_ago,
                                dataCard.date
                            ), fontSize = 13.sp, color = Black66
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.latest),
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W600
                )
                TextButton(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
                        contentColor = Black66
                    )
                ) {
                    Text(text = stringResource(id = R.string.see_all))
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(state.value.topNews) {
                    ItemHomeNews(articleUiModel = it)
                }
            }
        }
    }
}