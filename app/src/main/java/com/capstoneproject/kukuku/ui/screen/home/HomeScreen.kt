package com.capstoneproject.kukuku.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.R
import com.capstoneproject.kukuku.di.Injection
import com.capstoneproject.kukuku.model.DessertList
import com.capstoneproject.kukuku.ui.common.UiState
import com.capstoneproject.kukuku.ui.common.components.DessertsCatalog
import com.capstoneproject.kukuku.ui.screen.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        when(it) {
            is UiState.Loading -> {
                viewModel.getAllData()
            }
            is UiState.Success -> {

                HomeListData(dessertList = it.data, navigateToDetail = navigateToDetail)

            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeListData(
    dessertList: List<DessertList>,
    navigateToDetail: (Long) -> Unit
) {
//    Text(text = Resources.getSystem().getString(R.string.tbk) )
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.yct),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom =0.dp)
            )
            Text(
                text = stringResource(id = R.string.tips),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 20.dp, end=20.dp)
            )

            LazyRow {

                items(dessertList) {
                    DessertsCatalog(
                        name = it.dessert.dessert_name,
                        highlights = it.dessert.dessert_highlights,
                        image = it.dessert.dessert_picture,
                        modifier = Modifier.clickable {
                            navigateToDetail(it.dessert.id)
                        })
                }


            }

            Text(
                text = stringResource(id = R.string.langkah),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom =0.dp)
            )
            Text(
                text = stringResource(id = R.string.langkah_desc),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Left,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 21.dp, end=20.dp)
            )

//           ROW - TRUE - WRONG
            Row{

                Card(

                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp ,bottom = 20.dp),
//                    backgroundColor = Color.White
                ) {
                    AsyncImage(
                        model = "https://i.ibb.co/G25w3kR/benar.png",
                        contentDescription = "benar",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp ,bottom = 20.dp),
                ) {
                    AsyncImage(
                        model = "https://i.ibb.co/QQvm235/salah.png",
                        contentDescription = "salah",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
}