package com.backpacker.svgdogsapi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.backpacker.svgdogsapi.data.model.DogImageEntity

@Dao
interface DogImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(dogImage: DogImageEntity)

    @Query("SELECT * FROM recent_images ORDER BY rowid DESC LIMIT 20")
    suspend fun getRecentImages(): List<DogImageEntity>

    @Query("DELETE FROM recent_images")
    suspend fun clearAllImages()

    @Query("DELETE FROM recent_images WHERE rowid NOT IN (SELECT rowid FROM recent_images ORDER BY rowid DESC LIMIT 20)")
    suspend fun deleteOldestImages()
}
