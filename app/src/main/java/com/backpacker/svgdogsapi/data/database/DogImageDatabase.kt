package com.backpacker.svgdogsapi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.backpacker.svgdogsapi.data.dao.DogImageDao
import com.backpacker.svgdogsapi.data.model.DogImageEntity

@Database(entities = [DogImageEntity::class], version = 1, exportSchema = false)
abstract class DogImageDatabase : RoomDatabase() {
    abstract fun dogImageDao(): DogImageDao
}
