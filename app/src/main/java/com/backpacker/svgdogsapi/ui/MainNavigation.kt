package com.backpacker.svgdogsapi.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.backpacker.svgdogsapi.ui.generateimage.GenerateImageScreen
import com.backpacker.svgdogsapi.ui.generateimage.GenerateImageViewModel
import com.backpacker.svgdogsapi.ui.home.HomeScreen
import com.backpacker.svgdogsapi.ui.recentimages.RecentImagesScreen
import com.backpacker.svgdogsapi.ui.recentimages.RecentImagesViewModel

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }

        composable("generate_dogs") {
            val viewModel = hiltViewModel<GenerateImageViewModel>()
            GenerateImageScreen(viewModel = viewModel)
        }

        composable("recent_dogs") {
            val viewModel = hiltViewModel<RecentImagesViewModel>()
            RecentImagesScreen(viewModel = viewModel)
        }
    }
}
