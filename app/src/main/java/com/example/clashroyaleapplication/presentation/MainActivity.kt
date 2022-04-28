package com.example.clashroyaleapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clashroyaleapplication.presentation.features.cards.ui.CardsScreen
import com.example.clashroyaleapplication.presentation.features.favorites.ui.FavoritesScreen
import com.example.clashroyaleapplication.presentation.splash.SplashScreen
import com.example.clashroyaleapplication.presentation.core_ui.theme.ClashRoyaleApplicationTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClashRoyaleApplicationTheme {
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {

        composable("splash_screen") {
            SplashScreen {
                navController.navigate("cards_screen")
            }
        }
        composable("cards_screen") {
            CardsScreen {
                navController.navigate("favorites_screen")
            }
        }
        composable("favorites_screen") {
            FavoritesScreen()
        }
    }
}