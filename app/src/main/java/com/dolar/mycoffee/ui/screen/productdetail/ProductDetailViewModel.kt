package com.dolar.mycoffee.ui.screen.productdetail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dolar.mycoffee.R
import com.dolar.mycoffee.base.BaseViewModel
import com.dolar.mycoffee.entity.CoffeeResult
import com.dolar.mycoffee.entity.coffeelist.Coffee
import com.dolar.mycoffee.entity.coffeelist.CoffeeEntity
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by R. Mert Dolar on 14.02.2022.
 */
class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository) : BaseViewModel() {

    private var _favoriteImageResourceLiveData =
        MutableStateFlow<Int>(R.drawable.ic_favorite)
    val favoriteImageResourceLiveData: StateFlow<Int> get() = _favoriteImageResourceLiveData

    fun setFavIconResource(coffeeId : String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _favoriteImageResourceLiveData.value = if (productDetailRepository.isCoffeeAlreadyInFavorites(coffeeId.toInt())) {
                    R.drawable.ic_added_fav
                } else {
                    R.drawable.ic_favorite
                }
            }
        }
    }

    fun addOrRemoveFavoriteCoffee(coffee : CoffeeEntity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                if(productDetailRepository.isCoffeeAlreadyInFavorites(coffee.id)){
                    productDetailRepository.removeCoffeeFromFavoritesById(coffee.id)
                    Log.d("Operation","Delete - ${coffee.title}")
                    _favoriteImageResourceLiveData.value = R.drawable.ic_favorite
                }else{
                    productDetailRepository.addCoffeeToFavoriteList(coffee)
                    Log.d("Operation","Add - ${coffee.title}")
                    _favoriteImageResourceLiveData.value = R.drawable.ic_added_fav
                }
            }
        }
    }
}