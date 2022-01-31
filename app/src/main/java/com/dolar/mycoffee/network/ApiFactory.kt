package com.dolar.mycoffee.network

import com.dolar.mycoffee.common.enum.CoffeeType
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
interface ApiFactory {

    @GET("coffee/{type}")
    suspend fun getCoffeeListByType(@Path("type") type : String = CoffeeType.HOT.type) : Response<CoffeeListResponse?>


}