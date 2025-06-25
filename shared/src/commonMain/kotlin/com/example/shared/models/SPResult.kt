package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class SPResult(
    val status: Int = 0,
    val message: String? = null,
    val response: JsonElement? = null,
    val url: String? = null
) {
    override fun toString(): String {
        return "$message, $response, "
    }
}