package com.example.implementingexchangerateapiwithmvvmarchitecture.data


/**
 * Repository class for handling data operations related to exchange rates.
 * It acts as an abstraction layer between the ViewModel and the API service.
 */
class ExchangeRateRepository {

    /**
     * Fetches exchange rates from the API.
     * This is a suspend function, meaning it should be called within a coroutine or another suspend function.
     *
     * @return ExchangeRateResponse containing the list of exchange rates.
     */
    suspend fun getExchangeRates(): ExchangeRateResponse {
        return ApiClient.retrofit.getExchangeRates()
    }
}