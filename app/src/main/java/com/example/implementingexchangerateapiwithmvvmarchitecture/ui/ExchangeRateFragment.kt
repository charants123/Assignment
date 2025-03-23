package com.example.implementingexchangerateapiwithmvvmarchitecture.ui
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.ExchangeRateViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.SharedViewModel


class ExchangeRateFragment : Fragment() {
    val TAG = "ExchangeRateFragment"

    // Shared ViewModel to share data between fragments
    private val sharedViewModel: SharedViewModel by activityViewModels()

    // ViewModel for fetching exchange rates
    private val viewModel: ExchangeRateViewModel by viewModels()

    private lateinit var exchangeRateAdapter: ExchangeRateAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_exchange_rate, container, false) // Inflate the fragment layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()) // Set layout manager

        // Initialize adapter with empty list and click listener
        exchangeRateAdapter = ExchangeRateAdapter(emptyList()) { selectedRate ->
            sharedViewModel.selectExchangeRate(selectedRate) // Store selected item in SharedViewModel
            Log.d(TAG, "Setting exchange rate: $selectedRate")
            openDetailsFragment(selectedRate)  // Open DetailsFragment manually
        }

        recyclerView.setHasFixedSize(true) // Optimize performance
        recyclerView.adapter = exchangeRateAdapter // Set adapter to RecyclerView

        // Observe data from ViewModel and update adapter when data changes
        viewModel.exchangeRates.observe(viewLifecycleOwner) { rates ->
            Log.d(TAG, "onViewCreated: $rates")
            exchangeRateAdapter.updateData(rates)
        }

        // Fetch exchange rate data from API
        viewModel.fetchExchangeRates()
    }

    // Function to open the DetailsFragment and display selected exchange rate details
    private fun openDetailsFragment(exchangeRate: ExchangeRate) {
        val detailsFragment = DetailsFragment()

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)  // Replace current fragment with DetailsFragment
            .addToBackStack(null)  // Add transaction to back stack for navigation
            .commit()
    }
}
