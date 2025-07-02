package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement // For flexible Map<String, Any> representation

@Serializable
data class Predicate(
    val action: String? = null,
    val actionConfig: Map<String, JsonElement>? = null, // HashMap becomes Map<String, JsonElement>
    val condition: String? = null,
    val skipPredicateExecutionOnClient: Boolean = false // boolean primitive defaults to false
) {
    companion object {
        const val APPLY_ACCESS_MATRIX = "APPLY_ACCESS_MATRIX"
        const val SHOW = "SHOW"
        const val FILTER = "FILTER"
        const val MAKE_MANDATORY = "MAKE_MANDATORY"
        const val CALC = "CALC"
        const val COPY = "COPY"
        const val VALIDATE = "VALIDATE"
        const val OPTION_FILTER = "OPTION_FILTER"
        const val APPEND = "APPEND"
        const val GEO_FENCE = "GEO_FENCE"
        const val FACE_MATCH = "FACE_MATCH"
    }
}