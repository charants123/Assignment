package com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRateRepository
import kotlinx.coroutines.launch

class ExchangeRateViewModel : ViewModel() {
    val TAG: String = "ViewModel"

    // Repository instance to fetch exchange rates
    private val repository = ExchangeRateRepository()

    // LiveData to hold exchange rates data
    private val _exchangeRates = MutableLiveData<List<ExchangeRate>>()
    val exchangeRates: LiveData<List<ExchangeRate>> get() = _exchangeRates

    // LiveData to hold error messages
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    // Function to fetch exchange rates from the repository
    fun fetchExchangeRates() {
        viewModelScope.launch {
            try {
                // Fetch data from repository
                val response = repository.getExchangeRates()

                // Update LiveData with the fetched data
                _exchangeRates.postValue(response.data)

                Log.d(TAG, "fetchExchangeRates: $response")
            } catch (e: Exception) {
                // If an error occurs, update the error LiveData
                _error.postValue("Failed to fetch data: ${e.message}")

                Log.e(TAG, "fetchExchangeRates Error: ", e)
            }
        }
    }
}

