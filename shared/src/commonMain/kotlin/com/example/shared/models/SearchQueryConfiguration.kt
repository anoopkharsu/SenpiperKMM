package com.example.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class SearchQueryConfiguration(
    val fieldType: String? = null,
    val wildCardQuery: Boolean = false,
    val matchQuery: Boolean = false,
    val from: Double? = null,
    val to: Double? = null
)