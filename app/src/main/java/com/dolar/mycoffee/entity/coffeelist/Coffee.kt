package com.dolar.mycoffee.entity.coffeelist

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.reflect.TypeToken

import com.google.gson.Gson
import java.lang.reflect.Type


data class Coffee(
    val description: String,
    val id: Int,
    val ingredients: List<String>,
    val title: String)
