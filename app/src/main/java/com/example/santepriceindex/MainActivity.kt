package com.example.santepriceindex

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.santepriceindex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        binding.cardPriceWatch.setOnClickListener {
            startActivity(Intent(this, PriceWatchActivity::class.java))
        }

        binding.cardProfitCalc.setOnClickListener {
            startActivity(Intent(this, ProfitCalculatorActivity::class.java))
        }

        binding.cardPriceBoard.setOnClickListener {
            startActivity(Intent(this, PriceBoardActivity::class.java))
        }
    }
}
