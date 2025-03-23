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

/**
 * DetailsFragment is responsible for displaying the details of a selected exchange rate.
 * It observes the shared ViewModel to update the UI when data changes.
 */
class DetailsFragment : Fragment() {

    private val TAG: String = "DetailsFragment"

    // Shared ViewModel to get the selected exchange rate from the parent activity
    private val sharedViewModel: SharedViewModel by activityViewModels()

    /**
     * Inflates the layout for this fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    /**
     * Called after the view is created. Initializes UI components and observes ViewModel data.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        // Initializing UI elements
        val recordDateTextView: TextView = view.findViewById(R.id.tvRecordDate)
        val countryTextView: TextView = view.findViewById(R.id.tvCountry)
        val currencyTextView: TextView = view.findViewById(R.id.tvCurrency)
        val countryDescTextView: TextView = view.findViewById(R.id.tvDescription)
        val exchangeRateTextView: TextView = view.findViewById(R.id.tvExchangeRate)
        val effectiveDateTextView: TextView = view.findViewById(R.id.tvEffectiveDate)

        // Observing the selected exchange rate data from ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.selectedExchangeRate.observe(viewLifecycleOwner) { exchangeRate ->
                Log.d(TAG, "Observer triggered inside coroutine")

                // Updating UI with the selected exchange rate details
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

    /**
     * Lifecycle method called when the fragment becomes visible.
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    /**
     * Lifecycle method called when the fragment view is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView called")
    }
}
