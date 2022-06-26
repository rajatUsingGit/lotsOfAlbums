package com.example.lotsofalbums

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class Repository(private val remoteDatabase: WebApiService = WebApi.retrofitService) {

    suspend fun getAlbumsFromNetwork(): List<AlbumItem> {
        return remoteDatabase.getAlbums();
    }

/*    suspend fun getPhotosFromNetwork(id: Int): List<PhotoItem> {
        return withContext(Dispatchers.IO) {
            try {
                remoteDatabase.getPhotos(id).body()?.photoItems ?: emptyList()
            } catch(exception: Exception) {
                emptyList()
            }
        }
    }*/

}