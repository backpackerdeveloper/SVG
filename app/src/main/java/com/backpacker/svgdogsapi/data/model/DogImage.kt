package com.backpacker.svgdogsapi.data.model

data class DogImage(val imageUrl: String) {

    // Helper Function : image ko data class entity mai bhi use ho jaye (easy conversion)
    fun toEntity(): DogImageEntity {
        return DogImageEntity(imageUrl = this.imageUrl)
    }
}

data class DogImageResponse(
    val message: String,
    val status: String
)
