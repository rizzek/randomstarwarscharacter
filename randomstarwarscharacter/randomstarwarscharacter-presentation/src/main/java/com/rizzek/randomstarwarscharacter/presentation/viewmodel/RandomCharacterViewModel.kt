package com.rizzek.randomstarwarscharacter.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizzek.randomstarwarscharacter.domain.NetworkResource
import com.rizzek.randomstarwarscharacter.domain.entity.StarWarsCharacter
import com.rizzek.randomstarwarscharacter.domain.repository.CharacterRepository
import com.rizzek.randomstarwarscharacter.domain.usecase.GetRandomCharacter
import com.rizzek.randomstarwarscharacter.presentation.RandomCharacterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RandomCharacterViewModel @Inject constructor(
    private val getRandomCharacter: GetRandomCharacter,
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val _randomCharacterState = MutableStateFlow<RandomCharacterUiState>(
        value = RandomCharacterUiState(
            isLoading = false,
            character = null,
            errorMessage = null
        )
    )

    val randomCharacter: StateFlow<RandomCharacterUiState> = _randomCharacterState.asStateFlow()


    fun fetchNewRandomCharacter() {
        viewModelScope.launch {
            _randomCharacterState.update {
                it.copy(isLoading = true)
            }
            try {
                val randomCharacter = getRandomCharacter()
                if (randomCharacter is NetworkResource.Success) {
                    _randomCharacterState.update {
                        it.copy(isLoading = false, character = randomCharacter.data, errorMessage = null)
                    }
                } else {
                    _randomCharacterState.update {
                        it.copy(isLoading = false, errorMessage = "Error fetching character.")
                    }
                }

            } catch (e: Exception) {
                Log.e("RandomCharacterViewModel", "Error fetching character", e)
                _randomCharacterState.update {
                    // Some more sophisticated error handling could be done here, e.g. mapping the exception to a string resource or something
                    it.copy(isLoading = false, errorMessage = "Error fetching character")
                }
            }
        }
    }

}