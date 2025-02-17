package com.backpacker.svgdogsapi.ui.generateimage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.backpacker.svgdogsapi.util.Constants

@Composable
fun GenerateImageScreen(viewModel: GenerateImageViewModel) {
    val dogImage by viewModel.dogImageFlow.collectAsState()
    val loadingState by viewModel.loadingState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (loadingState) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        } else {
            Button(
                onClick = { viewModel.generateDogImage() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(Constants.BUTTON_COLOR))
            ) {
                Text("Generate!")
            }
        }
        
        dogImage?.let {
            Image(
                painter = rememberImagePainter(data = it.imageUrl),
                contentDescription = "Generated Dog",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}
