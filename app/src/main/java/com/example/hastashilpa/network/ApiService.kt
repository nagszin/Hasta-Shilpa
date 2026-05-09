package com.example.hastashilpa.network

import com.example.hastashilpa.data.DesignItem
import com.example.hastashilpa.data.ProductItem
import retrofit2.http.GET

interface ApiService {
    @GET("designs")
    suspend fun getTrendingDesigns(): List<DesignItem>

    @GET("marketplace")
    suspend fun getMarketplaceProducts(): List<ProductItem>
}