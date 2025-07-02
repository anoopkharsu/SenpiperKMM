package com.example.shared.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class SearchQuery(
    val searchQueries: List<SearchQuery>? = null,
    val type: String? = null,
    val operator: String? = null,
    val key: String? = null,
    val value: String? = null,
    val from: String? = null,
    val to: String? = null,
    val stringValues: List<String>? = null, // ArrayList becomes List<String>
    val numberValues: List<Double>? = null,
    val period: String? = null,
    val parentFieldKey: String? = null,
    val parentFieldName: String? = null
) {
    // Properties marked with @JsonIgnore in Java become @Transient in Kotlinx Serialization.
    // They won't be serialized/deserialized but will be part of the data class in memory.
    @Transient
    var masterId: String? = null // UUID as String for multiplatform

    @Transient
    var formId: String? = null // UUID as String for multiplatform

    @Transient
    var modelSchemaProperty: ModelSchemaProperty? = null

    companion object {
        // Search query operators
        const val CONTAINS = "CONTAINS"
        const val EQUALS = "EQUALS"
        const val STARTS_WITH = "STARTS_WITH"
        const val ENDS_WITH = "ENDS_WITH"
        const val LESS_THAN = "LESS_THAN"
        const val GREATER_THAN = "GREATER_THAN"
        const val LESS_THAN_EQUAL = "LESS_THAN_EQUAL"
        const val GREATER_THAN_EQUAL = "GREATER_THAN_EQUAL"
        const val NOT_EQUALS = "NOT_EQUALS"
        const val RANGE = "RANGE"
        const val IN = "IN"
        const val AND = "AND"

        // Search query keys
        const val ANSWER_AS_STRING = "answerAsString"
        const val TEXT = "text"
        const val GROUP_ID = "groupId"
        const val FORM_ID = "formId"
        const val CREATED_ON = "createdOn"
        const val UPDATED_ON = "updatedOn"
        const val TIME_STAMP = "timestamp"
        const val TYPE = "type"
        const val PARENT_ANSWER_IDENTIFIER_FORM_ANSWER_ID = "parentAnswerIdentifier.formAnswerId"
        const val ACTION_BUTTONS_VALUE = "actionButtons.value"

        // Search query types
        const val FORM_ANSWER = "FormAnswer"
        const val FORM_ANSWER_DICTIONARY = "FormAnswerDictionary"
        const val GROUP_CHAT = "GroupChat"

        // Search query date params
        const val TODAY = "TODAY"
        const val YESTERDAY = "YESTERDAY"
        const val MTD = "MTD"
        const val WTD = "WTD"
        const val YTD = "YTD"
        const val CUSTOM_CAPS = "CUSTOM"
        const val LAST_7_DAYS_CAPS = "LAST 7 DAYS"
        const val LAST_15_DAYS_CAPS = "LAST 15 DAYS"
        const val LAST_30_DAYS_CAPS = "LAST 30 DAYS"

        // Search query direction
        const val DESC = "DESC"
        const val ASC = "ASC"
    }

    // Custom equals and hashCode for business logic
    // Note: If you're relying purely on data class auto-generated equals/hashCode
    // based on constructor properties, then this manual override might not be needed
    // unless 'key' is the *only* field that defines equality.
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SearchQuery) return false

        // Your custom Java logic handles null 'key' by setting it to an empty string.
        // In Kotlin, it's often cleaner to use safe calls or Elvis operator.
        val thisKey = this.key ?: ""
        val otherKey = other.key ?: ""

        return thisKey == otherKey
    }

    override fun hashCode(): Int {
        // Your custom Java logic for hashCode, adapting for null 'key'
        return (key ?: "").hashCode()
    }
}