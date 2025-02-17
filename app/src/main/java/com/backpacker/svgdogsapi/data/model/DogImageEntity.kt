package com.backpacker.svgdogsapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_images")
data class DogImageEntity(
    @PrimaryKey val imageUrl: String
)