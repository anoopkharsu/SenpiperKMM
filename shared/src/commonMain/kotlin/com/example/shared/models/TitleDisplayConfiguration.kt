package com.example.shared.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement // For handling generic Objects in the map

@Serializable
data class TitleDisplayConfiguration(
    val altText: String? = null,
    val fontSize: String? = null, // Can be String if it contains units (e.g., "16sp")
    val fontWeight: String? = null,
    val fontColor: String? = null,
    val backgroundColor: String? = null,
    val stroke: String? = null,
    val text: String? = null,
    val drawableStart: Int? = null, // Android resource ID would be an Int
    val intFontSize: Int? = null,   // Numeric font size
    val textAllCaps: Boolean = false, // Defaults to false if not present
    val renderAsButton: Boolean = false, // Defaults to false if not present
    val buttonConfiguration: Action? = null, // Nested data class
    val showTitle: Boolean? = null, // Use Boolean? if it can be explicitly null or absent
    val align: String? = null,
    val localisationMap: Map<String, Map<String, JsonElement>>? = null // Map for HashMap<String, HashMap<String, Object>>
)


@Serializable
data class RowHeaderDisplayConfiguration(
    val fontSize: String? = null,
    val fontWeight: String? = null,
    val fontColor: String? = null,
    val backgroundColor: String? = null
)