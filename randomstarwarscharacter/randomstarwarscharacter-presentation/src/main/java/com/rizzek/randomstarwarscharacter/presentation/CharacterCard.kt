package com.rizzek.randomstarwarscharacter.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter

@Composable
fun CharacterCard(character: StarWarsCharacter, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            val fields = listOf<Pair<String, String>>(
                "Name" to character.name,
                "Height" to character.height.toString(),
                "Mass" to character.mass.toString(),
                "Hair Color" to character.hairColor,
                "Skin Color" to character.skinColor,
                "Eye Color" to character.eyeColor,
                "Birth Year" to character.birthYear,
                "Gender" to character.gender
            )

            for ((index, field) in fields.withIndex()) {
                DataRow(label = field.first, value = field.second)
                if (index < fields.lastIndex) {
                    Spacer(modifier = Modifier.padding(vertical = 2.dp))
                }
            }
        }

    }
}

@Composable
private fun DataRow(label: String, value: String) {
    Row {
        Text(label, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(value)
    }
}

@Preview
@Composable
fun CharacterCardPreview() {
    CharacterCard(
        character = StarWarsCharacter(
            "Luke Skywalker",
            172,
            77,
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male"
        )
    )
}