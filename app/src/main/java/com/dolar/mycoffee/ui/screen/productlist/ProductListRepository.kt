package com.dolar.mycoffee.ui.screen.productlist

import com.dolar.mycoffee.common.enum.CoffeeType
import com.dolar.mycoffee.db.CoffeeDao
import com.dolar.mycoffee.entity.CoffeeResult
import com.dolar.mycoffee.entity.NetworkError
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import com.dolar.mycoffee.network.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
class ProductListRepository(private val apiFactory: ApiFactory, private val coffeeDao: CoffeeDao) {

    var coffeType = CoffeeType.HOT

    val coffeeListByTypeLiveData = flow<CoffeeResult<CoffeeListResponse?>> {
        val coffeeListResponse = apiFactory.getCoffeeListByType(coffeType.type)

        if (coffeeListResponse.isSuccessful) {
            emit(CoffeeResult.Success(coffeeListResponse.body()))
        } else {
            emit(
                CoffeeResult.Error(
                    NetworkError(
                        coffeeListResponse.code(),
                        coffeeListResponse.errorBody().toString(),
                        coffeeListResponse.message()
                    )
                )
            )
        }
    }.flowOn(Dispatchers.IO)

    val favCoffeeListLiveData = flow<CoffeeResult<CoffeeListResponse?>> {
        val favCoffeeList = coffeeDao.getFavoriteCoffeeList()?.map {
            Coffee(
                it.description,
                it.id,
                getListOfIngredients(it.ingredients),
                it.title
            )
        }

        if (!favCoffeeList.isNullOrEmpty()) {
            val coffeeListResponse = CoffeeListResponse()
            coffeeListResponse.addAll(favCoffeeList)
            emit(CoffeeResult.Success(coffeeListResponse))
        } else {
            emit(
                CoffeeResult.Error(
                    NetworkError(
                        9001,
                        "DB error",
                        ""
                    )
                )
            )
        }
    }.flowOn(Dispatchers.IO)


    private fun getListOfIngredients(ingredients: String): List<String> {
        return ingredients.removePrefix("[").removePrefix("]").split(",")
    }
}