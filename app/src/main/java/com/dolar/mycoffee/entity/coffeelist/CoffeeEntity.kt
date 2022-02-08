package com.dolar.mycoffee.entity.coffeelist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by R. Mert Dolar on 8.02.2022.
 */
@Entity(tableName = "coffeeTable")
data class CoffeeEntity(
    @PrimaryKey(autoGenerate = true)
    var coffeeID: Int = 0,
    @ColumnInfo(name = "coffee")
    val coffee: Coffee)