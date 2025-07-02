package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement // For handling generic 'Object' types

@Serializable
data class AccessMatrix(
    val visibility: String? = null,
    val role: List<String>? = null, // ArrayList<String> becomes List<String>?
    val userIds: List<String>? = null, // ArrayList<UUID> becomes List<String>? for serialization
    val answer: JsonElement? = null, // Object becomes JsonElement? for flexible JSON parsing
    val mandatory: Boolean? = null,
    val readOnly: Boolean? = null,
    val userProfileDriven: Boolean? = null,
    val appendOnly: Boolean = false, // boolean primitive, default to false if not present
    val viewModeVisibility: String? = null,
    val defaultMediaName: String? = null
)