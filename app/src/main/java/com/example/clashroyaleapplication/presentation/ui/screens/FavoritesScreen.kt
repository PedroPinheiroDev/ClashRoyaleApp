package com.example.clashroyaleapplication.presentation.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clashroyaleapplication.presentation.event.FavoritesEvent
import com.example.clashroyaleapplication.R
import com.example.clashroyaleapplication.presentation.ui.components.CardItem
import com.example.clashroyaleapplication.presentation.ui.components.CustomAlertDialog
import com.example.clashroyaleapplication.presentation.viewmodel.FavoritesViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel = getViewModel()) {
    val state = viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "logo",
                modifier = Modifier
                    .height(100.dp)
            )
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(items = state.value.list) { item ->
                CardItem(
                    imageUrl = item.imageUrl,
                    name = item.name
                ) {
                    viewModel.onEvent(
                        FavoritesEvent.OnClick(
                            item
                        )
                    )
                }
            }
        }

        if (state.value.isDialogOpen) {
            CustomAlertDialog(text = "Do you want to delete ?",
                clickPositive = {
                    viewModel.onEvent(FavoritesEvent.OnRemoveClick(card = state.value.card))
                },
                onDismissRequest = {
                    viewModel.onEvent(FavoritesEvent.OnDismissClick)
                })
        }
    }
}