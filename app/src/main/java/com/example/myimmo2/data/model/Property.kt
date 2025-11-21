package com.example.myimmo2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Property(
    val id: String,
    val agentId: String,
    val title: String,
    val description: String,
    val regionId: String,
    val cityId: String,
    val neighborhoodId: String,
    val price: Double,
    val type: PropertyType,
    val status: PropertyStatus,
    val imageUrls: List<String> = emptyList()
)

@Serializable
enum class PropertyType {
    SALE,
    RENTAL
}

@Serializable
enum class PropertyStatus {
    AVAILABLE,
    SOLD,
    RENTED
}
