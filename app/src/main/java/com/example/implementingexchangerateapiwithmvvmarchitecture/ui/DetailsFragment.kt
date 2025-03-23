package com.example.implementingexchangerateapiwithmvvmarchitecture.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.SharedViewModel
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {
    val TAG:String="DetailsFragment"
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        val recordDateTextView: TextView = view.findViewById(R.id.tvRecordDate)
        val countryTextView: TextView = view.findViewById(R.id.tvCountry)
        val currencyTextView: TextView = view.findViewById(R.id.tvCurrency)
        val countryDescTextView: TextView = view.findViewById(R.id.tvDescription)
        val exchangeRateTextView: TextView = view.findViewById(R.id.tvExchangeRate)
        val effectiveDateTextView: TextView = view.findViewById(R.id.tvEffectiveDate)


        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.selectedExchangeRate.observe(viewLifecycleOwner) { exchangeRate ->
                Log.d("DetailsFragment", "Observer triggered inside coroutine")

                exchangeRate?.let {
                    countryTextView.text = "Country: ${it.country}"
                    recordDateTextView.text = "Record Date: ${it.recordDate}"
                    currencyTextView.text = "Currency: ${it.currency}"
                    countryDescTextView.text = "Description: ${it.countryCurrencyDesc}"
                    exchangeRateTextView.text = "Exchange Rate: ${it.exchangeRate}"
                    effectiveDateTextView.text = "Effective Date: ${it.effectiveDate}"
                }
            }
        }

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("DetailsFragment", "onDestroyView called")
    }
}
