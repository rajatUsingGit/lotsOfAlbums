package com.example.lotsofalbums

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val remoteDatabase: WebApiService = WebApi.retrofitService) {

    suspend fun getAlbumsFromNetwork(): List<AlbumItem> {
        return withContext(Dispatchers.IO) {
            remoteDatabase.getAlbums()
        }
    }

    suspend fun getPhotosFromNetwork(id: Int): List<PhotoItem> {
        return withContext(Dispatchers.IO) {
            remoteDatabase.getPhotos(id)
        }
    }

}