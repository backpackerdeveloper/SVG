package com.backpacker.svgdogsapi.data.repository

import com.backpacker.svgdogsapi.data.model.DogImage
import com.backpacker.svgdogsapi.data.network.ImageApiService
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val apiService: ImageApiService) {

    suspend fun fetchRandomImage(): DogImage? {
        val response = apiService.getRandomImage()
        return if (response.isSuccessful) response.body() else null
    }
}