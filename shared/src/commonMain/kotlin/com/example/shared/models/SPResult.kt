package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.long
import kotlinx.serialization.json.longOrNull

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


    fun getResponseHashMap(): Map<String, Any> {
        // If response is not a JSON object, return empty map
        println(response)
        val obj = response as? JsonObject ?: return emptyMap()
        println(obj)
        val data = obj.mapValues { (_, element) ->
            element.toAny()
        }
        println(data)
        return data
    }

    // Recursively convert JsonElement to Kotlin Any
    private fun JsonElement.toAny(): Any = when (this) {
        is JsonObject   -> this.mapValues { it.value.toAny() }
        is JsonArray -> this.map { it.toAny() }
        is JsonPrimitive -> {
            when {
                this.booleanOrNull != null -> this.boolean
                this.longOrNull    != null -> this.long
                this.doubleOrNull  != null -> this.double
                this.isString               -> this.content
                else                        -> this.content
            }
        }
        else -> this.toString()
    }
}