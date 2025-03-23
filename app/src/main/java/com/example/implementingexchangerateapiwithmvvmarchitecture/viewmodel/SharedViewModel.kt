package com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

class SharedViewModel:ViewModel(){
    val TAG="SharedViewModel"
    private val _selectedExchangeRate=MutableLiveData<ExchangeRate>()
    val selectedExchangeRate:LiveData<ExchangeRate>get() = _selectedExchangeRate
    fun selectExchangeRate(exchangeRate: ExchangeRate){
        _selectedExchangeRate.value=exchangeRate
        Log.d("SharedViewModel", "Active Observers: ${_selectedExchangeRate.hasActiveObservers()}")
    }
}