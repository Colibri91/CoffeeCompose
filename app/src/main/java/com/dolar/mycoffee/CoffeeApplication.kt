package com.dolar.mycoffee

import android.app.Application
import com.dolar.mycoffee.db.coffeeDB
import com.dolar.mycoffee.network.networkModule
import com.dolar.mycoffee.ui.screen.productdetail.productDetailModule
import com.dolar.mycoffee.ui.screen.productlist.productListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
class CoffeeApplication : Application() {

    private val moduleList: List<Module> = listOf(
        coffeeDB,
        networkModule,
        productListModule,
        productDetailModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoffeeApplication)
            modules(moduleList)
        }
    }


}