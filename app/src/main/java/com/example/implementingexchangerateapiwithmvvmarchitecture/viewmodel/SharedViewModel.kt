package com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

class SharedViewModel : ViewModel() {
    val TAG = "SharedViewModel"

    // LiveData to hold the selected exchange rate
    private val _selectedExchangeRate = MutableLiveData<ExchangeRate>()
    val selectedExchangeRate: LiveData<ExchangeRate> get() = _selectedExchangeRate

    // Function to update the selected exchange rate
    fun selectExchangeRate(exchangeRate: ExchangeRate) {
        _selectedExchangeRate.value = exchangeRate
        Log.d(TAG, "Selected exchange rate updated: $exchangeRate")
        Log.d(TAG, "Active Observers: ${_selectedExchangeRate.hasActiveObservers()}")
    }
}