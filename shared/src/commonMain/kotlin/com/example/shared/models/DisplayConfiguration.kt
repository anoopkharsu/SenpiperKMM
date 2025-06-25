package com.example.shared.models
import kotlinx.serialization.Serializable

@Serializable
data class DisplayConfiguration(
    val squareLogo: String? = null,
    val logoUrl: String? = null,
    val displayName: String? = null,
    val privacyUrl: String? = null,
    val termsUrl: String? = null,
    val baseUrl: String? = null,
    val displayItems: List<DisplayItem>? = null,
    val appActionBarOrder: List<String>? = null,
    val landingPageId: String? = null,
    val actionBarItemDisplayConfiguration: Map<String, ActionBarItemDisplayConfiguration>? = null,
    val hideActionBar: Boolean = false
)

@Serializable
data class DisplayItem(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val iconUrl: String? = null
)

@Serializable
data class ActionBarItemDisplayConfiguration(
    val enabled: Boolean? = null,
    val order: Int? = null,
    val iconUrl: String? = null
)