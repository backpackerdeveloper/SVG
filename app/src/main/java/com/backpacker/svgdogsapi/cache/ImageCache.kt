package com.backpacker.svgdogsapi.cache

import com.backpacker.svgdogsapi.data.model.DogImage

class ImageCache private constructor(){
    private val cache: LinkedHashMap<String, DogImage> = LinkedHashMap(20, 0.75f, true)

    companion object {
        private var instance: ImageCache? = null
        fun getInstance(): ImageCache {
            if (instance == null) {
                instance = ImageCache()
            }
            return instance!!
        }
    }

    fun addImage(dogImage: DogImage) {
        if (cache.size >= 20) {
            val oldestKey = cache.keys.first()
            cache.remove(oldestKey)
        }
        cache[dogImage.imageUrl] = dogImage
    }

    fun getAllImages(): List<DogImage> = cache.values.toList()

    fun clear() = cache.clear()
}