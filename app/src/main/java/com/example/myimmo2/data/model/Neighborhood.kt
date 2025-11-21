package com.example.myimmo2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Neighborhood(
    val id: String,
    val cityId: String,
    val name: String
)
