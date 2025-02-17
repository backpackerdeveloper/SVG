package com.backpacker.svgdogsapi.ui.generateimage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backpacker.svgdogsapi.cache.ImageCache
import com.backpacker.svgdogsapi.data.model.DogImage
import com.backpacker.svgdogsapi.data.repository.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenerateImageViewModel @Inject constructor(private val repository: ImagesRepository) : ViewModel() {

    private val _dogImageFlow = MutableStateFlow<DogImage?>(null)
    val dogImageFlow: StateFlow<DogImage?> get() = _dogImageFlow

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> get() = _loadingState

    fun generateDogImage() {
        _loadingState.value = true
        viewModelScope.launch {
            val dogImage = repository.fetchRandomImage()
            _loadingState.value = false
            if (dogImage != null) {
                ImageCache.getInstance().addImage(dogImage)
                _dogImageFlow.value = dogImage
            }
        }
    }
}
