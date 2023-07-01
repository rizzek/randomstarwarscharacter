package com.rizzek.randomstarwarscharacter.data.repository

import com.rizzek.randomstarwarscharacter.data.remote.StarWarsApiService
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterService: StarWarsApiService) :
    CharacterRepository {
    override suspend fun getStarWarsCharacter(id: Int): StarWarsCharacter {
        val remoteCharacter = characterService.getStarWarsCharacter(id = id)
        return remoteCharacter.toEntity()
    }


}