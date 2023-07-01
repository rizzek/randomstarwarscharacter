package com.rizzek.randomstarwarscharacter.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizzek.randomstarwarscharacter.domain.NetworkResource
import com.rizzek.randomstarwarscharacter.domain.usecase.GetRandomCharacter
import com.rizzek.randomstarwarscharacter.presentation.screens.RandomCharacterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RandomCharacterViewModel @Inject constructor(
    private val getRandomCharacter: GetRandomCharacter
) : ViewModel() {

    private val _randomCharacterState = MutableStateFlow(
        value = RandomCharacterUiState(
            isLoading = false,
            character = null,
            isError = false
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
                        it.copy(isLoading = false, character = randomCharacter.data, isError = false)
                    }
                } else {
                    _randomCharacterState.update {
                        it.copy(isLoading = false, isError = true)
                    }
                }

            } catch (e: Exception) {
                Log.e("RandomCharacterViewModel", "Error fetching character", e)
                _randomCharacterState.update {
                    // Some more sophisticated error handling could be done here, e.g. mapping the exception to a string resource or something
                    it.copy(isLoading = false, isError = true)
                }
            }
        }
    }

}