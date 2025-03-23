package com.example.implementingexchangerateapiwithmvvmarchitecture.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing an exchange rate record.
 * Each property is mapped to the corresponding JSON field using @SerializedName.
 */
data class ExchangeRate(
    @SerializedName("record_date") val recordDate: String,  // Date when the exchange rate was recorded
    @SerializedName("country") val country: String,  // Country name
    @SerializedName("currency") val currency: String,  // Currency code (e.g., USD, EUR)
    @SerializedName("country_currency_desc") val countryCurrencyDesc: String,  // Description of country and currency
    @SerializedName("exchange_rate") val exchangeRate: String,  // Exchange rate value
    @SerializedName("effective_date") val effectiveDate: String  // Date when the exchange rate is effective
)

/**
 * Data class representing the API response for exchange rates.
 * It contains a list of ExchangeRate objects.
 */
data class ExchangeRateResponse(
    @SerializedName("data") val data: List<ExchangeRate>  // List of exchange rate records from the API
)