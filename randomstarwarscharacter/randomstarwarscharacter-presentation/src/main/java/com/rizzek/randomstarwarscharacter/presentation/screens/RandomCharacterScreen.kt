package com.rizzek.randomstarwarscharacter.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.presentation.R
import com.rizzek.randomstarwarscharacter.presentation.viewmodel.RandomCharacterViewModel

@Composable
fun RandomCharacterScreen() {
    val viewModel = viewModel<RandomCharacterViewModel>()
    val screenState by viewModel.randomCharacter.collectAsState()
    RandomCharacterScreenContent(
        randomCharacterUiState = screenState,
        onFetchCharacterClicked = { viewModel.fetchNewRandomCharacter() }
    )
}

@Composable
private fun RandomCharacterScreenContent(
    randomCharacterUiState: RandomCharacterUiState,
    onFetchCharacterClicked: () -> Unit
) {
    Scaffold { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = stringResource(id = R.string.random_character_title),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Button(onClick = onFetchCharacterClicked) {
                Text(text = stringResource(id = R.string.random_character_button))
            }

            if (randomCharacterUiState.isError) {
                Text(
                    text = stringResource(id = R.string.error_label),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }

            if (randomCharacterUiState.isLoading) {
                CircularProgressIndicator()
            }

            randomCharacterUiState.character?.let { character ->
                CharacterCard(character = character, modifier = Modifier.padding(16.dp))
            }

        }
    }
}



// --------------- Previews ---------------


// You could also add another preview for dark mode, other language settings, screen sizes, ...
@Preview
@Preview(locale = "de")
@Composable
fun RandomCharacterScreenContentPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = false,
            character = StarWarsCharacter(
                "Luke Skywalker",
                "172",
                "77",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male"
            ),
            isError = false
        ),
        onFetchCharacterClicked = {}
    )
}

@Preview
@Preview(locale = "de")
@Composable
fun RandomCharacterScreenContentLoadingPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = true,
            character = null,
            isError = false
        ),
        onFetchCharacterClicked = {}
    )
}

@Preview
@Preview(locale = "de")
@Composable
fun RandomCharacterScreenContentErrorPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = false,
            character = null,
            isError = true
        ),
        onFetchCharacterClicked = {}
    )
}