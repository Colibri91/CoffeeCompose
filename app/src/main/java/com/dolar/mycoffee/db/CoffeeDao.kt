package com.dolar.mycoffee.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity

/**
 * Created by R. Mert Dolar on 8.02.2022.
 */
@Dao
interface CoffeeDao {
    @Query("select * from coffeeTable")
    fun getFavoriteCoffeeList(): List<CoffeeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoffeeToFavList(coffee: CoffeeEntity)

    @Delete
    fun deleteCoffeeFromFavList(deleteCoffee: CoffeeEntity)
}