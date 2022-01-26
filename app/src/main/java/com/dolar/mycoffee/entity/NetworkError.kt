package com.dolar.mycoffee.entity

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
data class NetworkError(val errorCode: Int,
                        val error : String? = "",
                        val error_description : String? = "")