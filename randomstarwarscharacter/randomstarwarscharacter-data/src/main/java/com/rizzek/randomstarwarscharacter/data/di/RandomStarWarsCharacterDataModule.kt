package com.rizzek.randomstarwarscharacter.data.di

import com.rizzek.randomstarwarscharacter.data.remote.StarWarsApiService
import com.rizzek.randomstarwarscharacter.data.repository.CharacterRepositoryImpl
import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RandomStarWarsCharacterDataModule {

    @Provides
    fun provideCharacterApiService(): StarWarsApiService {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsApiService::class.java)
    }

    @Provides
    fun provideCharacterRepository(
        starWarsApiService: StarWarsApiService
    ): CharacterRepository {
        return CharacterRepositoryImpl(characterService = starWarsApiService)
    }
}