package com.dolar.mycoffee.entity

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */

sealed class CoffeeResult<T> {
    data class Success<T>(val data: T) : CoffeeResult<T>()
    data class Error<T>(val error: NetworkError) : CoffeeResult<T>()
}