package com.rizzek.randomstarwarscharacter.domain.entity

/**
 * Domain entity for a Star Wars character. If we wanted to do some caching via Room in the
 * data layer we could also make this an interface and have a Room implementation of it.
 */
data class StarWarsCharacter(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
)
