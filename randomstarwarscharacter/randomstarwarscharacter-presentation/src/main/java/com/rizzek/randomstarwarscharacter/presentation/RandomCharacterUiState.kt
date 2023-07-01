package com.rizzek.randomstarwarscharacter.presentation

import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

data class RandomCharacterUiState(
    val isLoading: Boolean,
    val character: StarWarsCharacter?,
    val errorMessage: String?
)
