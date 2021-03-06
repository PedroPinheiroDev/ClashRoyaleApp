package com.example.clashroyaleapplication.presentation.features.cards.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clashroyaleapplication.R
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.presentation.features.cards.event.CardsScreenEvent
import com.example.clashroyaleapplication.presentation.core_ui.components.CardItem
import com.example.clashroyaleapplication.presentation.core_ui.components.CustomAlertDialog
import com.example.clashroyaleapplication.presentation.features.cards.viewmodel.CardsViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun CardsScreen(viewModel: CardsViewModel = getViewModel(), onFavoriteClick: () -> Unit = {}) {
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
                    .padding(horizontal = 30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_star_24),
                contentDescription = "favorites",
                modifier = Modifier
                    .height(100.dp)
                    .clickable {
                        onFavoriteClick()
                    }
            )
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(items = state.value.list) { item ->
                CardItem(
                    imageUrl = item.imageUrl,
                    name = item.name,
                    onClick = {
                        viewModel.onEvent(
                            CardsScreenEvent.OnClick(
                                Card(
                                    item.imageUrl,
                                    item.id,
                                    item.maxLevel,
                                    item.name
                                )
                            )
                        )
                    }
                )
            }
        }

        if (state.value.isDialogOpen) {
            CustomAlertDialog("Do you want to save ?",
                onDismissRequest = {
                    viewModel.onEvent(CardsScreenEvent.OnDismissClick)
                },
                clickPositive = {
                    viewModel.onEvent(CardsScreenEvent.OnFavoriteClick(viewModel.state.value.card))
                })
        }
    }
}