package com.capstoneproject.kukuku.ui.common.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ArticleCatalog(
    name: String,
    highlights: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(300.dp).height(200.dp).padding(start = 20.dp, end = 5.dp, top = 20.dp, bottom = 20.dp),
    ) {
            AsyncImage(
                model = image,
                contentDescription = "article_image",
                contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxSize()
            )
    }
}
