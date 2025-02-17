package com.backpacker.svgdogsapi.ui.recentimages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.backpacker.svgdogsapi.data.dao.DogImageDao
import com.backpacker.svgdogsapi.data.model.DogImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentImagesViewModel @Inject constructor(
    private val dogImageDao: DogImageDao
) : ViewModel() {

    private val _recentImageFlow = MutableStateFlow<List<DogImage>>(emptyList())
    val recentImageFlow: StateFlow<List<DogImage>> = _recentImageFlow.asStateFlow()

    init {
        loadRecentDogs()
    }

    fun loadRecentDogs() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val dogImageEntities = dogImageDao.getRecentImages()
                _recentImageFlow.value = dogImageEntities.map { DogImage(it.imageUrl) }
            } catch (e: Exception) {

                e.printStackTrace()
            }
        }
    }

    fun clearDogs() {
        viewModelScope.launch {
            try {
                dogImageDao.clearAllImages()
                _recentImageFlow.value = emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
