package com.rizzek.randomstarwarscharacter.data.remote

import com.google.gson.annotations.SerializedName
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

data class RemoteStarWarsCharacter(
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("gender")
    val gender: String
) {
    /**
     * Returns this Remote model as a domain entity.
     */
    fun toEntity(): StarWarsCharacter {
        return StarWarsCharacter(
            name = this.name,
            height = this.height,
            mass = this.mass,
            hairColor = this.hairColor,
            skinColor = this.skinColor,
            eyeColor = this.eyeColor,
            birthYear = this.birthYear,
            gender = this.gender
        )
    }
}