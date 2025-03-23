package com.example.implementingexchangerateapiwithmvvmarchitecture.data


class ExchangeRateRepository{
    suspend fun getExchangeRates(): ExchangeRateResponse {
        return ApiClient.retrofit.getExchangeRates()
    }
}