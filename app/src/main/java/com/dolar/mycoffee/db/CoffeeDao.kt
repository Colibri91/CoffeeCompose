package com.dolar.mycoffee.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity

/**
 * Created by R. Mert Dolar on 8.02.2022.
 */
@Dao
interface CoffeeDao {
    @Query("select * from coffeeTable")
    fun getFavoriteCoffeeList(): LiveData<List<CoffeeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoffeeToFavList(addUser: CoffeeEntity)

    @Query("UPDATE coffeeTable SET coffee =:coffee where coffeeID=:id")
    fun updateCoffeeInFavList(id: Int, coffee: Coffee)

    @Delete
    fun deleteCoffeeFromFavList(deleteUser: CoffeeEntity)
}