package com.example.myimmo2.data.model

import kotlinx.serialization.Serializable

@Serializable
sealed class User {
    abstract val id: String
    abstract val email: String
    abstract val firstName: String
    abstract val lastName: String
}

@Serializable
data class Agent(
    override val id: String,
    override val email: String,
    override val firstName: String,
    override val lastName: String,
    val agencyName: String? = null,
    val phoneNumber: String,
) : User()

@Serializable
data class Visitor(
    override val id: String,
    override val email: String,
    override val firstName: String,
    override val lastName: String,
) : User()

@Serializable
data class Admin(
    override val id: String,
    override val email: String,
    override val firstName: String,
    override val lastName: String,
) : User()
