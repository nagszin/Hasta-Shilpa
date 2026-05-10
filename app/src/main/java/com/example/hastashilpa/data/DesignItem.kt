package com.example.hastashilpa.data

import java.io.Serializable

data class DesignItem(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val measurements: String = "",
    val materials: String = "",
    val difficulty: String = "Medium",
    val estimatedTime: String = "5 hours"
) : Serializable