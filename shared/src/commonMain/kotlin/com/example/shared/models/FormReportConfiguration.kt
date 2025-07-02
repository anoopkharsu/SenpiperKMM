package com.example.shared.models


import kotlinx.serialization.Serializable

@Serializable
data class FormReportConfiguration(
    val reportId: String? = null, // UUID as String for multiplatform compatibility
    val reportDisplayConfiguration: ReportDisplayConfiguration? = null
) {
    // No need to override toString() as data class provides it
}

@Serializable
data class ReportDisplayConfiguration(
    val mode: String? = null,
    val displayType: String? = null
) {
    companion object {
        const val VIEW = "view"
        const val SELECT = "select"
    }
    // No need to override toString() as data class provides it
}