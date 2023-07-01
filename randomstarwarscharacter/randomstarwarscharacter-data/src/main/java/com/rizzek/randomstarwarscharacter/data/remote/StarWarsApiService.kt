package com.rizzek.randomstarwarscharacter.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApiService {

    @GET("people/{id}")
    suspend fun getStarWarsCharacter(@Path("id") id: Int): Response<RemoteStarWarsCharacter>
}