package com.example.implementingexchangerateapiwithmvvmarchitecture.ui


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

/**
 * Adapter for displaying a list of exchange rates in a RecyclerView.
 * It binds exchange rate data to the corresponding UI elements.
 *
 * @param exchangeRates List of exchange rate data.
 * @param onItemClick Callback function triggered when an item is clicked.
 */
class ExchangeRateAdapter(private var exchangeRates: List<ExchangeRate>, private val onItemClick: (ExchangeRate) -> Unit) :
    RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateViewHolder>() {
        val TAG:String="ExchangeRateAdapter"
    /**
     * ViewHolder class representing each item in the RecyclerView.
     */
  inner class ExchangeRateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryText: TextView = view.findViewById(R.id.tvCountry)
        val currencyText: TextView = view.findViewById(R.id.tvCurrency)
        /**
         * Binds the exchange rate data to the item view and sets click listener.
         */
        fun bind(exchangeRate: ExchangeRate){
                itemView.setOnClickListener { onItemClick(exchangeRate) }
            }
    }
    /**
     * Creates and returns a ViewHolder for each item in the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange_rate, parent, false)
        Log.d(TAG, "onCreateViewHolder: ")
        return ExchangeRateViewHolder(view)
    }
    /**
     * Binds data to the ViewHolder at the specified position.
     */
    override fun onBindViewHolder(holder: ExchangeRateViewHolder, position: Int) {
        val exchangeRate = exchangeRates[position]
        holder.countryText.text = "Country: ${exchangeRate.country}"
        holder.currencyText.text = "Currency: ${exchangeRate.currency}"
        holder.bind(exchangeRate)
        Log.d(TAG, "onBindViewHolder: ")
        holder.itemView.setOnClickListener { onItemClick(exchangeRate)
        }
    }
    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount(): Int = exchangeRates.size

    /**
     * Updates the dataset with new exchange rates and refreshes the RecyclerView.
     *
     * @param newRates The updated list of exchange rates.
     */
    fun updateData(newRates: List<ExchangeRate>) {
        Log.d(TAG, "updateData: ")
        this.exchangeRates = newRates
        notifyDataSetChanged()
    }

}
