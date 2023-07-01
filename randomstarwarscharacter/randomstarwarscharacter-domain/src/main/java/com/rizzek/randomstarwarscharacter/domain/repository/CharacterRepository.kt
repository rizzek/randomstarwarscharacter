package com.rizzek.randomstarwarscharacter.domain.repository

import com.rizzek.randomstarwarscharacter.domain.NetworkResource
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

/**
 * Repository interface for getting Star Wars characters. In a more complex app, this would probably
 * use some kind of data source abstraction.
 */
interface CharacterRepository {

    suspend fun  getStarWarsCharacter(id: Int): NetworkResource<StarWarsCharacter>
}