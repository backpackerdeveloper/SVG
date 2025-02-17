package com.backpacker.svgdogsapi.data.network

import com.backpacker.svgdogsapi.data.model.DogImageResponse
import com.backpacker.svgdogsapi.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ImageApiService {
    @GET(Constants.ENDPOINT)
    suspend fun getRandomImage(): Response<DogImageResponse> // Chnages Dog class to response....
}