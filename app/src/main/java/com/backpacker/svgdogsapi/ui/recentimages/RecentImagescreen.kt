package com.backpacker.svgdogsapi.ui.recentimages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.backpacker.svgdogsapi.util.Constants

@Composable
fun RecentImagesScreen(viewModel: RecentImagesViewModel) {
    val recentImages by viewModel.recentImageFlow.collectAsState()

    Column {
        Button(
            onClick = { viewModel.clearDogs() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(Constants.BUTTON_COLOR))
        ) {
            Text("Clear Dogs")
        }

        LazyColumn {
            items(recentImages) { dogImage ->
                Image(
                    painter = rememberImagePainter(data = dogImage.imageUrl),
                    contentDescription = "Dog Image",
                    modifier = Modifier.size(150.dp)
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadRecentDogs()
    }
}
