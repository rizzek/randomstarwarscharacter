package com.rizzek.randomstarwarscharacter.domain.repository

import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

interface CharacterRepository {

    suspend fun  getStarWarsCharacter(id: Int): StarWarsCharacter
}