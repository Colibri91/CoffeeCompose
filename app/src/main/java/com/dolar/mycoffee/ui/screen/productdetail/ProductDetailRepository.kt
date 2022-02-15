package com.dolar.mycoffee.ui.screen.productdetail

import com.dolar.mycoffee.db.CoffeeDao
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity

/**
 * Created by R. Mert Dolar on 14.02.2022.
 */
class ProductDetailRepository(private val coffeeDao: CoffeeDao) {

    fun addCoffeeToFavoriteList(coffee : CoffeeEntity) {
        coffeeDao.addCoffeeToFavList(coffee)
    }

}