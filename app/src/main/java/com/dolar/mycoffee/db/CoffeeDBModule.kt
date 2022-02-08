package com.dolar.mycoffee.db

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by R. Mert Dolar on 8.02.2022.
 */
val coffeeDB = module {
    fun provideDataBase(application: Application): CoffeeDB {
        return Room.databaseBuilder(application, CoffeeDB::class.java, "COFFEEDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideDao(dataBase: CoffeeDB): CoffeeDao {
        return dataBase.coffeeDao
    }
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }

}