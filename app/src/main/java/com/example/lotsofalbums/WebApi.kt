package com.example.lotsofalbums

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebApiService {
    @GET("albums")
    suspend fun getAlbums(): List<AlbumItem>

    @GET("photos")
    suspend fun getPhotos(@Query("id") id: Int): List<PhotoItem>
}

private val sRetrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object WebApi {
    val retrofitService: WebApiService by lazy { sRetrofit.create(WebApiService::class.java) }
}