package com.dolar.mycoffee.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinComponent

/**
 * Created by R. Mert Dolar on 7.01.2022.
 */
open class BaseViewModel() : ViewModel(), KoinComponent {

    val eventShowOrHideProgress = MutableLiveData<Boolean>()
    val eventOnError = MutableLiveData<Any>()

    fun showProgress() {
        eventShowOrHideProgress.value = true
    }

    fun hideProgress() {
        eventShowOrHideProgress.value = false
    }

}