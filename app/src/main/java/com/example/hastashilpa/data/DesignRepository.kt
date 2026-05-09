package com.example.hastashilpa.data

import com.example.hastashilpa.network.RetrofitClient

class DesignRepository {
    suspend fun getTrendingDesigns(): List<DesignItem> {
        return try {
            RetrofitClient.apiService.getTrendingDesigns()
        } catch (e: Exception) {
            // Fallback to dummy data if backend is not running
            listOf(
                DesignItem(1, "Modern Bamboo Lamp", "Network Fallback: A sleek lamp shade.", "https://example.com/lamp.jpg", "30cm x 15cm", "Bamboo, Glue", "Medium", "5 hours"),
                DesignItem(2, "Bamboo Laptop Stand", "Network Fallback: Ergonomic stand.", "https://example.com/stand.jpg", "40cm x 25cm", "Bamboo poles", "Easy", "3 hours")
            )
        }
    }
}