package com.example.implementingexchangerateapiwithmvvmarchitecture.data

import com.google.gson.annotations.SerializedName

data class ExchangeRate(@SerializedName("record_date") val recordDate: String,
                        @SerializedName("country") val country: String,
                        @SerializedName("currency") val currency: String,
                        @SerializedName("country_currency_desc") val countryCurrencyDesc: String,
                        @SerializedName("exchange_rate") val exchangeRate: String,
                        @SerializedName("effective_date") val effectiveDate: String)

data class ExchangeRateResponse( @SerializedName("data") val data: List<ExchangeRate>)