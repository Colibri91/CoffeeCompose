package com.dolar.mycoffee.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity

/**
 * Created by R. Mert Dolar on 8.02.2022.
 */
@Database(entities = [CoffeeEntity::class], version = 1, exportSchema = false)
abstract class CoffeeDB : RoomDatabase() {
    abstract val coffeeDao: CoffeeDao
}