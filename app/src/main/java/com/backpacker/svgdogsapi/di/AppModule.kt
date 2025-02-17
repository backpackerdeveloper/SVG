package com.backpacker.svgdogsapi.di

import android.content.Context
import androidx.room.Room
import com.backpacker.svgdogsapi.data.dao.DogImageDao
import com.backpacker.svgdogsapi.data.database.DogImageDatabase
import com.backpacker.svgdogsapi.data.network.ImageApiService
import com.backpacker.svgdogsapi.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiService(): ImageApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDogImageDatabase(@ApplicationContext context: Context): DogImageDatabase {
        return Room.databaseBuilder(
            context,
            DogImageDatabase::class.java,
            "dog_image_database"
        ).build()
    }

    @Provides
    fun provideDogImageDao(database: DogImageDatabase): DogImageDao {
        return database.dogImageDao()
    }
}
