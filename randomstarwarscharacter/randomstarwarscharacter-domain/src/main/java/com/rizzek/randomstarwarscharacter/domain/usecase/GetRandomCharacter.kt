package com.rizzek.randomstarwarscharacter.domain.usecase

import com.rizzek.randomstarwarscharacter.domain.NetworkResource
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import kotlin.random.Random

/**
 * Use case for getting a random Star Wars character.
 */
class GetRandomCharacter(
    private val characterRepository: CharacterRepository
) {

    suspend operator fun invoke(): NetworkResource<StarWarsCharacter> {
        // As of creating this app, there are 82 characters in the Star Wars API.
        // In a more sophisticated app, we would want to get the count of characters from the
        // API (and store it locally for performance reasons), but for now, we will just hardcode the number.
        val characterId = Random.nextInt(1, 82)
        return characterRepository.getStarWarsCharacter(id = characterId)
    }
}