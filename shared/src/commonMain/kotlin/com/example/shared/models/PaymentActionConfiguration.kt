package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement // For 'onSuccess' field

@Serializable
data class PaymentActionConfiguration(
    val paymentGateway: String? = null,
    val name: String? = null,
    val description: String? = null,
    val image: String? = null,
    val themeColor: String? = null,
    val prefillEmailKey: String? = null,
    val prefillContactKey: String? = null,
    val prefillNameKey: String? = null,
    val retryConfig: RetryConfig? = null,
    val onSuccess: JsonElement? = null, // Using JsonElement to represent flexible JSON for onSuccess
    val onFail: OnFail? = null,
    val amountFormField: String? = null,
    val currencyFormField: String? = null,
    val notes: String? = null,
    val timeout: Int? = null
)

@Serializable
data class RetryConfig(
    val enabled: Boolean? = null,
    val maxCount: Int? = null
)

@Serializable
data class OnFail(
    val value: String? = null,
    val actionType: String? = null,
    val autoTrigger: Boolean? = null,
    val status: String? = null
)