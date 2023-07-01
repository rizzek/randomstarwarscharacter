package com.rizzek.randomstarwarscharacter.domain

/**
 * Normally, this would probably be in some kind of "commons" module.
 */
sealed class NetworkResource<T> {
    data class Success<T>(val data: T): NetworkResource<T>()
    data class Error<T>(val message: String): NetworkResource<T>()
}
