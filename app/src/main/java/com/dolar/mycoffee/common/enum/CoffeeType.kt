package com.dolar.mycoffee.common.enum

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
enum class CoffeeType(val type : String) {
    HOT("hot"),
    ICED("iced");

    companion object {
        fun getValueByType(value: String) = values().first { it.type == value }
    }
}