package com.rizzek.randomstarwarscharacter.presentation.screens

import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

data class RandomCharacterUiState(
    val isLoading: Boolean,
    val character: StarWarsCharacter?,
    val isError: Boolean
)
