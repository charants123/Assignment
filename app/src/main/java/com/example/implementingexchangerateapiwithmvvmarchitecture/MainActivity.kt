package com.example.implementingexchangerateapiwithmvvmarchitecture

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController


import com.example.implementingexchangerateapiwithmvvmarchitecture.ui.ExchangeRateFragment

class MainActivity : AppCompatActivity() {
    val TAG:String="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null){
            Log.d(TAG, "onCreate: "+savedInstanceState)
            val fragment:ExchangeRateFragment=ExchangeRateFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
        }

    }
}