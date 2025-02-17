package com.backpacker.svgdogsapi.data.model

data class DogImage(
    val imageUrl: String
)

data class DogImageResponse(
    val message: String,
    val status: String
)
