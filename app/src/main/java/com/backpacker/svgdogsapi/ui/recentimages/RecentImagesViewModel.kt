package com.backpacker.svgdogsapi.ui.recentimages

import androidx.lifecycle.ViewModel
import com.backpacker.svgdogsapi.cache.ImageCache
import com.backpacker.svgdogsapi.data.model.DogImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RecentImagesViewModel @Inject constructor() : ViewModel() {

    private val _recentDogsFlow = MutableStateFlow<List<DogImage>>(emptyList())
    val recentImageFlow: StateFlow<List<DogImage>> get() = _recentDogsFlow

    fun loadRecentDogs() {
        _recentDogsFlow.value = ImageCache.getInstance().getAllImages()
    }

    fun clearDogs() {
        ImageCache.getInstance().clear()
        _recentDogsFlow.value = emptyList()
    }
}
