package com.rizzek.randomstarwarscharacter.domain.entity

data class StarWarsCharacter(
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
)
