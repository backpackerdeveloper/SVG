package com.backpacker.svgdogsapi.data.repository

import com.backpacker.svgdogsapi.data.model.DogImage
import com.backpacker.svgdogsapi.data.network.ImageApiService
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val apiService: ImageApiService) {

    suspend fun fetchRandomImage(): DogImage? {
        val response = apiService.getRandomImage()
        return if (response.isSuccessful) {

            // Initially we take only imageUrl not respective of api response
            // so lets Map the message from DogImageResponse to DogImage
            response.body()?.let { body ->
                DogImage(body.message)
            }
        } else {
            null
        }
    }
}