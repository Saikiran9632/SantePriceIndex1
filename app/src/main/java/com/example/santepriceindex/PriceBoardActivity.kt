package com.example.santepriceindex

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.santepriceindex.databinding.ActivityPriceBoardBinding

class PriceBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPriceBoardBinding
    private val mandiPrices = VegetableRepository.getMandiPrices()
    private var currentIndex = 0
    private val handler = Handler(Looper.getMainLooper())
    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            currentIndex = (currentIndex + 1) % mandiPrices.size
            updateDisplay()
            handler.postDelayed(this, 5000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPriceBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateDisplay()

        binding.root.setOnClickListener {
            handler.removeCallbacks(autoScrollRunnable)
            currentIndex = (currentIndex + 1) % mandiPrices.size
            updateDisplay()
            handler.postDelayed(autoScrollRunnable, 5000)
        }
        
        handler.postDelayed(autoScrollRunnable, 5000)
    }

    private fun updateDisplay() {
        val veg = mandiPrices[currentIndex]
        binding.tvBoardItemName.text = veg.name.uppercase()
        binding.tvBoardPrice.text = "₹${veg.price.toInt()}"
        
        // AI Logic for board: Show dynamic trend
        val predicted = VegetableRepository.getAIPricePrediction(veg.name)
        if (predicted > veg.price) {
            binding.tvBoardTrend.text = "▲ AI TRENDING UP"
            binding.tvBoardTrend.setTextColor(getColor(android.R.color.holo_blue_light))
        } else {
            binding.tvBoardTrend.text = "▼ AI TRENDING DOWN"
            binding.tvBoardTrend.setTextColor(getColor(android.R.color.holo_red_light))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(autoScrollRunnable)
    }
}
