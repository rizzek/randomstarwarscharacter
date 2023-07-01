package com.rizzek.randomstarwarscharacter.data.repository

import com.rizzek.randomstarwarscharacter.data.remote.StarWarsApiService
import com.rizzek.randomstarwarscharacter.domain.NetworkResource
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: StarWarsApiService):
            CharacterRepository {
        override suspend fun getStarWarsCharacter(id: Int): NetworkResource<StarWarsCharacter> {
            val remoteCharacterResponse = characterService.getStarWarsCharacter(id = id)
            val remoteCharacter = remoteCharacterResponse.body()
            return if (remoteCharacterResponse.isSuccessful && remoteCharacter != null) {
                NetworkResource.Success(remoteCharacter.toEntity())
            } else {
                NetworkResource.Error(remoteCharacterResponse.message())
            }
        }
    }