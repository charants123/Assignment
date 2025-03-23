package com.example.implementingexchangerateapiwithmvvmarchitecture.ui


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate


class ExchangeRateAdapter(private var exchangeRates: List<ExchangeRate>, private val onItemClick: (ExchangeRate) -> Unit) :
    RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateViewHolder>() {
        val TAG:String="ExchangeRateAdapter"

  inner class ExchangeRateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryText: TextView = view.findViewById(R.id.tvCountry)
        val currencyText: TextView = view.findViewById(R.id.tvCurrency)
            fun bind(exchangeRate: ExchangeRate){
                itemView.setOnClickListener { onItemClick(exchangeRate) }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        Log.d(TAG, "onCreateViewHolder: ")
        return ExchangeRateViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExchangeRateViewHolder, position: Int) {
        val exchangeRate = exchangeRates[position]
        holder.countryText.text = "Country: ${exchangeRate.country}"
        holder.currencyText.text = "Currency: ${exchangeRate.currency}"
        holder.bind(exchangeRate)
        Log.d(TAG, "onBindViewHolder: ")
        holder.itemView.setOnClickListener { onItemClick(exchangeRate)
        }
    }

    override fun getItemCount(): Int = exchangeRates.size

    fun updateData(newRates: List<ExchangeRate>) {
        Log.d(TAG, "updateData: ")
        this.exchangeRates = newRates
        notifyDataSetChanged()
    }

}
