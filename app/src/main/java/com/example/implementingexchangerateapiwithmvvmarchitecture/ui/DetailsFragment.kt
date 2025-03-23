package com.example.implementingexchangerateapiwithmvvmarchitecture.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.SharedViewModel

class DetailsFragment : Fragment() {
        private val sharedViewModel:SharedViewModel= SharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recordDateTextView: TextView = view.findViewById(R.id.tvRecordDate)
        val countryTextView: TextView = view.findViewById(R.id.tvCountry)
        val currencyTextView: TextView = view.findViewById(R.id.tvCurrency)
        val countryDescTextView: TextView = view.findViewById(R.id.tvDescription)
        val exchangeRateTextView: TextView = view.findViewById(R.id.tvExchangeRate)
        val effectiveDateTextView: TextView = view.findViewById(R.id.tvEffectiveDate)





        sharedViewModel.selectedExchangeRate.observe(viewLifecycleOwner) { exchangeRate ->
            recordDateTextView.text = "Record Date: ${exchangeRate.record_date}"
            countryTextView.text = "Country: ${exchangeRate.country}"
            currencyTextView.text = "Currency: ${exchangeRate.currency}"
            countryDescTextView.text = "Description: ${exchangeRate.country_currency_desc}"
            exchangeRateTextView.text = "Rate: ${exchangeRate.exchange_rate}"
            effectiveDateTextView.text = "Effective Date: ${exchangeRate.effective_date}"
        }

    }
}
