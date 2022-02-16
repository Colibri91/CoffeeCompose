package com.dolar.mycoffee.ui.screen.productdetail

import com.dolar.mycoffee.db.CoffeeDao
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity

/**
 * Created by R. Mert Dolar on 14.02.2022.
 */
class ProductDetailRepository(private val coffeeDao: CoffeeDao) {

    suspend fun addCoffeeToFavoriteList(coffee : CoffeeEntity) {
        coffeeDao.addCoffeeToFavList(coffee)
    }

    suspend fun isCoffeeAlreadyInFavorites(id : Int) : Boolean{
        return coffeeDao.isCoffeeAlreadyInFavorites(id)
    }

    suspend fun removeCoffeeFromFavoritesById(id : Int) {
        coffeeDao.deleteCoffeeFromFavoritesById(id)
    }



}