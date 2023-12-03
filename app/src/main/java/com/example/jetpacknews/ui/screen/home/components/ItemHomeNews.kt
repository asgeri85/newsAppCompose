package com.example.jetpacknews.ui.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacknews.R
import com.example.jetpacknews.domain.model.ArticleUiModel
import com.example.jetpacknews.ui.components.CustomAsyncImage
import com.example.jetpacknews.ui.theme.Black66

@Composable
fun ItemHomeNews(
    modifier: Modifier = Modifier,
    articleUiModel: ArticleUiModel
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        CustomAsyncImage(
            url = articleUiModel.image,
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(6.dp)),
            scale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = "USA", fontSize = 13.sp, color = Black66)
            Text(
                text = articleUiModel.title,
                fontSize = 16.sp,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                CustomAsyncImage(
                    url = articleUiModel.source,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(100f),
                        )
                        .size(20.dp),
                    scale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = articleUiModel.sourceName,
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
                        text = if (articleUiModel.date == 0) stringResource(id = R.string.now) else stringResource(
                            id = R.string.hours_ago,
                            articleUiModel.date
                        ),
                        fontSize = 13.sp,
                        color = Black66,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}