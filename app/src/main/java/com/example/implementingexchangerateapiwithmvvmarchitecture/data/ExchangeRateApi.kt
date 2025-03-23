package com.example.implementingexchangerateapiwithmvvmarchitecture.data

import retrofit2.http.GET


/**
 * Retrofit interface to define API endpoints for fetching exchange rates.
 */
interface ExchangeRateApi {

    /**
     * Fetches the exchange rates from the API.
     * This function is a suspend function, meaning it runs asynchronously using Kotlin coroutines.
     *
     * @return ExchangeRateResponse containing a list of exchange rate records.
     */
    @GET("v1/accounting/od/rates_of_exchange")
    suspend fun getExchangeRates(): ExchangeRateResponse
}