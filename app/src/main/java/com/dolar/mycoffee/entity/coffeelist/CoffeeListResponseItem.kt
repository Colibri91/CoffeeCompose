package com.dolar.mycoffee.entity.coffeelist

data class CoffeeListResponseItem(
    val description: String,
    val id: Int,
    val ingredients: List<String>,
    val title: String
)