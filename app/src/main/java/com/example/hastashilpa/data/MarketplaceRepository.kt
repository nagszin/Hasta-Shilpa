package com.example.hastashilpa.data

import com.example.hastashilpa.network.RetrofitClient

class MarketplaceRepository {
    suspend fun getMarketplaceProducts(): List<ProductItem> {
        return try {
            RetrofitClient.apiService.getMarketplaceProducts()
        } catch (e: Exception) {
            // Fallback to dummy data if backend is not running
            listOf(
                ProductItem(1, "Handwoven Basket", 450.0, "Ramesh Rao", "Sirsi", "https://example.com/basket.jpg"),
                ProductItem(2, "Bamboo Chair", 2500.0, "Suresh Kumar", "Sagar", "https://example.com/chair.jpg")
            )
        }
    }
}