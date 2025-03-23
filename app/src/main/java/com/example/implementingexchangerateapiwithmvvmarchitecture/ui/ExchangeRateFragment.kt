package com.example.implementingexchangerateapiwithmvvmarchitecture.ui
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.implementingexchangerateapiwithmvvmarchitecture.R
import com.example.implementingexchangerateapiwithmvvmarchitecture.data.ExchangeRate

import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.ExchangeRateViewModel
import com.example.implementingexchangerateapiwithmvvmarchitecture.viewmodel.SharedViewModel



class ExchangeRateFragment : Fragment() {
    val TAG="ExchangeRateFragment"
    private val sharedViewModel:SharedViewModel=SharedViewModel()

    private lateinit var navController: NavController

    private val viewModel:ExchangeRateViewModel=ExchangeRateViewModel()

    private lateinit var exchangeRateAdapter: ExchangeRateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exchange_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
//        exchangeRateAdapter.

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        exchangeRateAdapter = ExchangeRateAdapter(emptyList()) { selectedRate ->
            sharedViewModel.selectExchangeRate(selectedRate)  // Set data in SharedViewModel
            navController=findNavController()
            findNavController().navigate(R.id.action_exchangeRateFragment_to_detailsFragment)
           
//            val action = ExchangeRateFragment()
//            findNavController().navigate(action)
        }
        recyclerView.adapter = exchangeRateAdapter


        viewModel.exchangeRates.observe(viewLifecycleOwner) { rates ->
            exchangeRateAdapter.updateData(rates)
        }



        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            Log.d(TAG, "onViewCreated: "+errorMessage)
        }
        viewModel.fetchExchangeRates()
    }
    fun onItemClick(exchangeRate: ExchangeRate){

    }
}
