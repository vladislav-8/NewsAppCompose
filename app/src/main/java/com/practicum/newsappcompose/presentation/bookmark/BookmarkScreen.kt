package com.practicum.newsappcompose.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.practicum.newsappcompose.presentation.Dimens.MediumPadding24
import com.practicum.newsappcompose.R
import com.practicum.newsappcompose.presentation.common.ArticlesList
import com.practicum.newsappcompose.presentation.navgraph.Route


@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigate: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding24, start = MediumPadding24, end = MediumPadding24)
    ) {
        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_title)
        )

        Spacer(modifier = Modifier.height(MediumPadding24))

        ArticlesList(
            articles = state.articles,
            onClick = { navigate(Route.DetailsScreen.route) }
        )
    }
}