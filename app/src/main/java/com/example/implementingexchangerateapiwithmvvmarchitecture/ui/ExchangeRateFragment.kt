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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.ExchangeRateViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.SharedViewModel



class ExchangeRateFragment : Fragment() {
    val TAG = "ExchangeRateFragment"
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: ExchangeRateViewModel  by viewModels()

    private lateinit var exchangeRateAdapter: ExchangeRateAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView: ")
        return inflater.inflate(R.layout.fragment_exchange_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        exchangeRateAdapter = ExchangeRateAdapter(emptyList()) { selectedRate ->
            sharedViewModel.selectExchangeRate(selectedRate)
            Log.d(TAG, "Setting exchange rate: $selectedRate")
            openDetailsFragment(selectedRate)  // Open DetailsFragment manually

        }
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = exchangeRateAdapter

        viewModel.exchangeRates.observe(viewLifecycleOwner) { rates ->
            Log.d(TAG, "onViewCreated: $rates")
            exchangeRateAdapter.updateData(rates)
        }
        viewModel.fetchExchangeRates()
    }

    private fun openDetailsFragment(exchangeRate: ExchangeRate) {
        val detailsFragment = DetailsFragment()

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)  // Replace fragment
            .addToBackStack(null)  // Enable back navigation
            .commit()
    }
}
