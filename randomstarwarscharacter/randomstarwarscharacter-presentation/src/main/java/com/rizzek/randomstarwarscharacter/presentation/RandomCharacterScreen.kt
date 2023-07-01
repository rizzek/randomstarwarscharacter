package com.rizzek.randomstarwarscharacter.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
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
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(
                text = "Random Star Wars Character",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Button(onClick = onFetchCharacterClicked) {
                Text(text = "Fetch a random character")
            }

            randomCharacterUiState.errorMessage?.let { errorMessage ->
                Text(
                    text = errorMessage,
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
@Composable
fun RandomCharacterScreenContentPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = false,
            character = StarWarsCharacter(
                "Luke Skywalker",
                172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male"
            ),
            errorMessage = null
        ),
        onFetchCharacterClicked = {}
    )
}

@Preview
@Composable
fun RandomCharacterScreenContentLoadingPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = true,
            character = null,
            errorMessage = null
        ),
        onFetchCharacterClicked = {}
    )
}

@Preview
@Composable
fun RandomCharacterScreenContentErrorPreview() {
    RandomCharacterScreenContent(
        randomCharacterUiState = RandomCharacterUiState(
            isLoading = false,
            character = null,
            errorMessage = "Error while fetching character"
        ),
        onFetchCharacterClicked = {}
    )
}