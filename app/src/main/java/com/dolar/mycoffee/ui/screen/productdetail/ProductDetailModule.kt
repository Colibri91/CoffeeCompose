package com.dolar.mycoffee.ui.screen.productdetail

import com.dolar.mycoffee.ui.screen.productlist.ProductListRepository
import com.dolar.mycoffee.ui.screen.productlist.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by R. Mert Dolar on 14.02.2022.
 */

val productDetailModule = module {
    viewModel { ProductDetailViewModel(get()) }
    factory { ProductDetailRepository(get()) }
}