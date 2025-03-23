package com.example.implementingexchangerateapiwithmvvmarchitecture.data

data class ExchangeRate(val record_date:String,val country:String,val currency:String,val country_currency_desc:String,val exchange_rate:String,val effective_date:String)

data class ExchangeRateResponse(val data:List<ExchangeRate>)