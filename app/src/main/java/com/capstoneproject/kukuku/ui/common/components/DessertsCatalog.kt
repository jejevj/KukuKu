package com.capstoneproject.kukuku.ui.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.ui.theme.KukukuApplicationTheme

@Composable
fun DessertsCatalog(
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
                contentDescription = "laptop_image",
                contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxSize()
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DessertCatalogPreview() {
    KukukuApplicationTheme {
        DessertsCatalog(name = "LAPTOP NAME", highlights = "laptop highlights", image = "")
    }
}