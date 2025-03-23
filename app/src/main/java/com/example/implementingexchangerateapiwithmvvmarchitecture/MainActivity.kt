package com.example.implementingexchangerateapiwithmvvmarchitecture


import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.implementingexchangerateapiwithmvvmarchitecture.ui.ExchangeRateFragment

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Check if this is the first time the activity is created
        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: First time launch, savedInstanceState is null")

            // Create an instance of ExchangeRateFragment
            val fragment: ExchangeRateFragment = ExchangeRateFragment()

            // Add the fragment to the container
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)  // Replace any existing fragment
                .commit()
        }
    }
}