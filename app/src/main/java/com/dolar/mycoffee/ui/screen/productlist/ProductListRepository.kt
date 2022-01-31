package com.dolar.mycoffee.ui.screen.productlist

import com.dolar.mycoffee.common.enum.CoffeeType
import com.dolar.mycoffee.entity.CoffeeResult
import com.dolar.mycoffee.entity.NetworkError
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import com.dolar.mycoffee.network.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
class ProductListRepository(private val apiFactory: ApiFactory) {

    var coffeType = CoffeeType.HOT

    val coffeeListByTypeLiveData = flow<CoffeeResult<CoffeeListResponse?>> {
        val coffeeListResponse = withContext(Dispatchers.IO){
            apiFactory.getCoffeeListByType(coffeType.type)
        }
        if(coffeeListResponse.isSuccessful){
            emit(CoffeeResult.Success(coffeeListResponse.body()))
        }else{
            emit(CoffeeResult.Error(NetworkError(coffeeListResponse.code(),
                coffeeListResponse.errorBody().toString(),
                coffeeListResponse.message())))
        }
    }.flowOn(Dispatchers.IO)
}