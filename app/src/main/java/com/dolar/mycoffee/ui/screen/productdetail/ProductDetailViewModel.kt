package com.dolar.mycoffee.ui.screen.productdetail

import android.util.Log
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

    fun addOrRemoveFavoriteCoffee(coffee : CoffeeEntity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                if(productDetailRepository.isCoffeeAlreadyInFavorites(coffee.id)){
                    productDetailRepository.removeCoffeeFromFavoritesById(coffee.id)
                    Log.d("Operation","Delete - ${coffee.title}")
                }else{
                    productDetailRepository.addCoffeeToFavoriteList(coffee)
                    Log.d("Operation","Add - ${coffee.title}")
                }
            }
        }
    }
}