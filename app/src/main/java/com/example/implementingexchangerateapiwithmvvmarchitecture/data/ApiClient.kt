package com.example.implementingexchangerateapiwithmvvmarchitecture.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton object to create and manage Retrofit instance.
 * Ensures a single instance of the API client is used throughout the app.
 */
object ApiClient {

    // Base URL for the exchange rate API
    private const val BASE_URL = "https://api.fiscaldata.treasury.gov/services/api/fiscal_service/"

    /**
     * Lazily initialized Retrofit instance to provide the ExchangeRateApi service.
     * Uses GsonConverterFactory to handle JSON conversion.
     */
    val retrofit: ExchangeRateApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Set API base URL
            .addConverterFactory(GsonConverterFactory.create()) // Convert JSON response to objects
            .build()
            .create(ExchangeRateApi::class.java) // Create API service
    }
}