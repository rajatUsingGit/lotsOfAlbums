package com.example.lotsofalbums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _albums: MutableStateFlow<List<AlbumItem>> = MutableStateFlow(emptyList())
    val albums: StateFlow<List<AlbumItem>> = _albums

    private var _photos: MutableStateFlow<List<PhotoItem>> = MutableStateFlow(emptyList())
    val photos: StateFlow<List<PhotoItem>> = _photos

    private val repository = Repository()

    fun refreshAlbumsList() {
        viewModelScope.launch {
            _albums.value = repository.getAlbumsFromNetwork()
        }
    }

/*    fun refreshAlbumsPhotos(id: Int) {
        viewModelScope.launch {
            _photos.value = repository.getPhotosFromNetwork(id)
        }
    }*/

}