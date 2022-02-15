package com.dolar.mycoffee.ui.screen.productdetail

import androidx.lifecycle.viewModelScope
import com.dolar.mycoffee.base.BaseViewModel
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by R. Mert Dolar on 14.02.2022.
 */
class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository) : BaseViewModel() {

    fun addCoffeeToFavoriteList(coffee : CoffeeEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                productDetailRepository.addCoffeeToFavoriteList(coffee)
            }
        }
    }
}