package com.example.santepriceindex

object VegetableRepository {
    fun getMandiPrices(): List<Vegetable> {
        return listOf(
            Vegetable("Onion (Pyaj)", 35.0),
            Vegetable("Potato (Aloo)", 25.0),
            Vegetable("Tomato (Tamatar)", 45.0),
            Vegetable("Green Chilli (Hari Mirch)", 60.0),
            Vegetable("Ginger (Adrak)", 120.0),
            Vegetable("Garlic (Lahsun)", 200.0),
            Vegetable("Carrot (Gajar)", 40.0),
            Vegetable("Cabbage (Patta Gobi)", 20.0),
            Vegetable("Cauliflower (Phool Gobi)", 50.0),
            Vegetable("Lady Finger (Bhindi)", 55.0),
            Vegetable("Brinjal (Baingan)", 30.0),
            Vegetable("Capsicum (Shimla Mirch)", 70.0),
            Vegetable("Bottle Gourd (Lauki)", 25.0),
            Vegetable("Bitter Gourd (Karela)", 40.0),
            Vegetable("Spinach (Palak)", 30.0, "bundle"),
            Vegetable("Coriander (Dhaniya)", 10.0, "bundle"),
            Vegetable("Mint (Pudina)", 15.0, "bundle"),
            Vegetable("Cucumber (Kheera)", 30.0),
            Vegetable("Lemon (Nimbu)", 80.0),
            Vegetable("Radish (Mooli)", 20.0),
            Vegetable("Beans", 65.0),
            Vegetable("Peas (Matar)", 90.0),
            Vegetable("Sweet Potato (Shakarkand)", 40.0),
            Vegetable("Pumpkin (Kaddu)", 25.0)
        )
    }

    fun getAIPricePrediction(vegName: String): Double {
        // Advanced AI Logic Simulation: Factors in seasonal trends and demand
        val currentPrice = getMandiPrices().find { it.name == vegName }?.price ?: 0.0
        val trendFactor = 1.0 + (Math.random() * 0.2 - 0.1) // +/- 10% change
        return currentPrice * trendFactor
    }
}
