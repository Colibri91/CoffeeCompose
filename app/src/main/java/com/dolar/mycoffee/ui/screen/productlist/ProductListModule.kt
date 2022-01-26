package com.dolar.mycoffee.ui.screen.productlist

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
val productListModule = module {
    viewModel { ProductListViewModel(get()) }
    factory { ProductListRepository(get()) }
}