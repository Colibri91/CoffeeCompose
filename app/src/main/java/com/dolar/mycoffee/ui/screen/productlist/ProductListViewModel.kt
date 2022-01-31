package com.dolar.mycoffee.ui.screen.productlist


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.dolar.mycoffee.base.BaseViewModel
import com.dolar.mycoffee.common.enum.CoffeeType
import com.dolar.mycoffee.entity.CoffeeResult
import com.dolar.mycoffee.entity.coffeelist.CoffeeListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
class ProductListViewModel(private val productListRepository: ProductListRepository) :
    BaseViewModel() {

    private var _coffeeListLiveData =
        MutableStateFlow<CoffeeResult<CoffeeListResponse?>>(CoffeeResult.Success(CoffeeListResponse()))
    val coffeListLiveData: StateFlow<CoffeeResult<CoffeeListResponse?>> get() = _coffeeListLiveData

    init {
        viewModelScope.launch {
            getCoffeeList()
        }
    }

    fun getCoffeeList(coffeeType : CoffeeType = CoffeeType.HOT) {
        productListRepository.coffeType = coffeeType
        viewModelScope.launch{
            showProgress()
            productListRepository.coffeeListByTypeLiveData.collect {
                _coffeeListLiveData.value = it
                hideProgress()
            }
        }
    }
}