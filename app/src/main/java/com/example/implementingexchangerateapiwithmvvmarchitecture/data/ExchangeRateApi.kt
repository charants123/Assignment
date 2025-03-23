package com.example.implementingexchangerateapiwithmvvmarchitecture.data

import retrofit2.http.GET


interface ExchangeRateApi{
    @GET("v1/accounting/od/rates_of_exchange")
    suspend fun getExchangeRates():ExchangeRateResponse
}