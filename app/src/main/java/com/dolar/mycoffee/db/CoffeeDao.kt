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
    suspend fun getFavoriteCoffeeList(): List<CoffeeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCoffeeToFavList(coffee: CoffeeEntity)

    @Query("select * from coffeeTable where id = :id")
    suspend fun getFavoriteCoffeeById(id : Int): CoffeeEntity

    @Query("select exists(select * from coffeeTable where id = :id)")
    suspend fun isCoffeeAlreadyInFavorites(id : Int) : Boolean

    @Query("delete from coffeeTable where id = :id")
    suspend fun deleteCoffeeFromFavoritesById(id: Int)
}