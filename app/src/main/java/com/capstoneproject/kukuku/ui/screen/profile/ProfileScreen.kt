package com.capstoneproject.kukuku.ui.screen.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.ui.theme.KukukuApplicationTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onBackClick:() -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
            Text(
                text = "KukuKu App",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "KukuKu adalah aplikasi yang memiliki teknologi untuk membantu deteksi dini  menganalisis gejala penyakit berdasarkan kondisi kuku dengan performa yang baik",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f))

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Meet Our Team",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(model = "https://i.ibb.co/4dNctzz/KUKUKU.jpg", contentDescription = "gambar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    KukukuApplicationTheme {
        ProfileScreen(onBackClick = {})
    }
}