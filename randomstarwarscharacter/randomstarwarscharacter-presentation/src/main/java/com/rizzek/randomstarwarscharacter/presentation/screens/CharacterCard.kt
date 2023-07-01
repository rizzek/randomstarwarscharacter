package com.rizzek.randomstarwarscharacter.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.presentation.R

@Composable
fun CharacterCard(character: StarWarsCharacter, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            val fields = listOf(
                stringResource(id = R.string.name_label) to character.name,
                stringResource(id = R.string.height_label) to character.height,
                stringResource(id = R.string.mass_label) to character.mass,
                stringResource(id = R.string.hair_color_label) to character.hairColor,
                stringResource(id = R.string.skin_color_label) to character.skinColor,
                stringResource(id = R.string.eye_color_label) to character.eyeColor,
                stringResource(id = R.string.birth_year_label) to character.birthYear,
                stringResource(id = R.string.gender_label) to character.gender
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
@Preview(locale = "de")
@Composable
fun CharacterCardPreview() {
    CharacterCard(
        character = StarWarsCharacter(
            "Luke Skywalker",
            "172",
            "77",
            "blond",
            "fair",
            "blue",
            "19BBY",
            "male"
        )
    )
}