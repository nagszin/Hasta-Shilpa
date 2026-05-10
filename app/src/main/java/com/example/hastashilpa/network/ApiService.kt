package com.example.hastashilpa.network

import com.example.hastashilpa.data.DesignItem
import com.example.hastashilpa.data.ProductItem
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class PriceCalculationRequest(
    val materialCost: Double,
    val laborHours: Double,
    val laborRate: Double,
    val profitPercent: Double
)

data class PriceCalculationResponse(
    val suggestedPrice: String,
    val baseCost: String,
    val profitAmount: String,
    val aiConfidence: String
)

data class ArtisanStats(
    val productsCreated: Int,
    val totalEarnings: Double,
    val rating: Double
)

interface ApiService {
    @GET("designs")
    suspend fun getTrendingDesigns(): List<DesignItem>

    @GET("marketplace")
    suspend fun getMarketplaceProducts(): List<ProductItem>

    @POST("calculate-price")
    suspend fun calculatePrice(@Body request: PriceCalculationRequest): PriceCalculationResponse

    @GET("artisan-stats")
    suspend fun getArtisanStats(): ArtisanStats
}