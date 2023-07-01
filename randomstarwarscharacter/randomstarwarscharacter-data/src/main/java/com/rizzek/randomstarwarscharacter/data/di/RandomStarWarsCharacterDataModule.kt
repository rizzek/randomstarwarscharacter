package com.rizzek.randomstarwarscharacter.data.di

import com.rizzek.randomstarwarscharacter.data.remote.StarWarsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
abstract class RandomStarWarsCharacterDataModule {

    @Provides
    fun provideCharacterApiService(): StarWarsApiService {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .build()
            .create(StarWarsApiService::class.java)
    }
}