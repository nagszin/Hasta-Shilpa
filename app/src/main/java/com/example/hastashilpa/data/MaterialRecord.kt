package com.example.hastashilpa.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "material_records")
data class MaterialRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val materialName: String,
    val quantity: Double,
    val laborHours: Double,
    val date: Long = System.currentTimeMillis()
)