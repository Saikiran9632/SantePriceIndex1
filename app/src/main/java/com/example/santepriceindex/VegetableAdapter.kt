package com.example.santepriceindex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.santepriceindex.databinding.ItemVegetableBinding

class VegetableAdapter(private val vegetables: List<Vegetable>) :
    RecyclerView.Adapter<VegetableAdapter.VegViewHolder>() {

    class VegViewHolder(val binding: ItemVegetableBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegViewHolder {
        val binding = ItemVegetableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VegViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VegViewHolder, position: Int) {
        val veg = vegetables[position]
        holder.binding.tvVegName.text = veg.name
        holder.binding.tvVegPrice.text = "₹${veg.price}/${veg.unit}"
        
        // Advanced AI Logic: Generate a dynamic prediction message
        val predictedPrice = VegetableRepository.getAIPricePrediction(veg.name)
        val diff = predictedPrice - veg.price
        val message = when {
            diff > 5 -> "High demand: Price may rise soon"
            diff < -5 -> "Supply surplus: Price likely to drop"
            else -> "Market stability: No major change expected"
        }
        holder.binding.tvAiPrediction.text = message
    }

    override fun getItemCount() = vegetables.size
}
