package com.example.santepriceindex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.santepriceindex.databinding.ActivityProfitCalculatorBinding
import java.text.NumberFormat
import java.util.Locale

class ProfitCalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfitCalculatorBinding
    private val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfitCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalculate.setOnClickListener {
            calculatePrice()
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun calculatePrice() {
        val purchase = binding.etPurchase.text.toString().toDoubleOrNull() ?: 0.0
        val transport = binding.etTransport.text.toString().toDoubleOrNull() ?: 0.0
        val profit = binding.etProfit.text.toString().toDoubleOrNull() ?: 0.0

        val finalPrice = purchase + transport + profit
        binding.tvResult.text = currencyFormat.format(finalPrice)
    }
}
