package com.example.santepriceindex

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.santepriceindex.databinding.ActivityPriceWatchBinding

class PriceWatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPriceWatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPriceWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.fabAddPrice.setOnClickListener {
            setupRecyclerView()
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val mandiPrices = VegetableRepository.getMandiPrices()
        binding.rvPriceList.layoutManager = LinearLayoutManager(this)
        binding.rvPriceList.adapter = VegetableAdapter(mandiPrices)
    }
}
