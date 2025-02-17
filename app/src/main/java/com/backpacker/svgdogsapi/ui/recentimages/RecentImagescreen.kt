package com.backpacker.svgdogsapi.ui.recentimages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.backpacker.svgdogsapi.util.Constants

@Composable
fun RecentImagesScreen(viewModel: RecentImagesViewModel) {
    val recentImages by viewModel.recentImageFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            items(recentImages) { dogImage ->
                Image(
                    painter = rememberImagePainter(data = dogImage.imageUrl),
                    contentDescription = "Dog Image",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(end = 8.dp)
                )
            }
        }

        Button(
            onClick = { viewModel.clearDogs() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(Constants.BUTTON_COLOR)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Clear Dogs")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadRecentDogs()
    }
}
