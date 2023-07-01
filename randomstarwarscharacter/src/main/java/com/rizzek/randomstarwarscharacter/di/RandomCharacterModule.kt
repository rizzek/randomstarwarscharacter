package com.rizzek.randomstarwarscharacter.di

import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import com.rizzek.randomstarwarscharacter.domain.usecase.GetRandomCharacter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RandomCharacterModule {

    @Provides
    fun provideGetRandomCharacterUseCase(
        characterRepository: CharacterRepository
    ): GetRandomCharacter {
        return GetRandomCharacter(characterRepository = characterRepository)
    }
}