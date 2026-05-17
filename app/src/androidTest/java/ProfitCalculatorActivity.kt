package com.example.santepriceindex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfitCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profit_calculator)

        val etPurchase = findViewById<EditText>(R.id.etPurchase)
        val etTransport = findViewById<EditText>(R.id.etTransport)
        val etWaste = findViewById<EditText>(R.id.etWaste)
        val etProfit = findViewById<EditText>(R.id.etProfit)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val purchase = etPurchase.text.toString().toDoubleOrNull() ?: 0.0
            val transport = etTransport.text.toString().toDoubleOrNull() ?: 0.0
            val waste = etWaste.text.toString().toDoubleOrNull() ?: 0.0
            val profit = etProfit.text.toString().toDoubleOrNull() ?: 0.0

            val totalCost = purchase + transport + waste
            val finalPrice = totalCost + (totalCost * profit / 100)

            tvResult.text = "Recommended Price: ₹ %.2f /kg".format(finalPrice)
        }
    }
}