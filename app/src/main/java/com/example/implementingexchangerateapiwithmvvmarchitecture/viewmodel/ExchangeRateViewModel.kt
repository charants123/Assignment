package com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRateRepository
import kotlinx.coroutines.launch




class ExchangeRateViewModel : ViewModel() {

    private val repository = ExchangeRateRepository()  // Repository instance

    private val _exchangeRates = MutableLiveData<List<ExchangeRate>>()

    val exchangeRates: LiveData<List<ExchangeRate>> get() = _exchangeRates
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchExchangeRates() {
        viewModelScope.launch {
            try {
                val response = repository.getExchangeRates()
                _exchangeRates.postValue(response.data)
            } catch (e: Exception) {
                _error.postValue("Failed to fetch data: ${e.message}")
            }
        }
    }
}