package com.example.myimmo2.data.model

import kotlinx.serialization.Serializable

@Serializable
data class City(
    val id: String,
    val regionId: String,
    val name: String
)
