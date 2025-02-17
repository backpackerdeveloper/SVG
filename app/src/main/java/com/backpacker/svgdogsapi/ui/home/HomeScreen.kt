package com.backpacker.svgdogsapi.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.backpacker.svgdogsapi.util.Constants

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("generate_dogs") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(Constants.BUTTON_COLOR))
        ) {
            Text("Generate Dogs")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("recent_dogs") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(Constants.BUTTON_COLOR))
        ) {
            Text("My Recently Generated Dogs")
        }

    }
}