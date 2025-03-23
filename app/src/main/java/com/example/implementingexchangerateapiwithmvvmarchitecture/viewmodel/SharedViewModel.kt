package com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

class SharedViewModel:ViewModel(){
    private val _selectedExchangeRate=MutableLiveData<ExchangeRate>()
    val selectedExchangeRate:LiveData<ExchangeRate>get() = _selectedExchangeRate
    fun selectExchangeRate(exchangeRate: ExchangeRate){
        _selectedExchangeRate.value=exchangeRate
    }
}