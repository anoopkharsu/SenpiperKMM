package com.example.shared.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class Action(
    val type: String? = null,
    val actionText: String? = null,
    val assigneeList: List<JsonElement>? = null, // Can be List<Any>? if you want to use Kotlin Any directly, but JsonElement is safer for unknown JSON structures
    val actionType: String? = null,
    val value: String? = null,
    val color: String? = null,
    val TTL: Long? = null, // Long? for long
    val visibility: List<String>? = null, // "AD_HOC", USER, ADMIN, SUPERADMIN
    val userIds: List<String>? = null, // UUID as String for multiplatform
    val editFullForm: Boolean = false,
    val remark: Boolean = false,
    val realTimeAudit: Boolean = false,
    val actionId: String? = null, // UUID as String for multiplatform
    val drawableStart: Int? = null, // Android resource ID will be an Int
    val drawableEnd: Int? = null, // Android resource ID will be an Int

    val formReportConfiguration: FormReportConfiguration? = null, // Nested type
    val localisationMap: Map<String, Map<String, JsonElement>>? = null, // Map for HashMap<String, HashMap<String, Object>>

    val actionButtonDisplayConfiguration: ActionButtonDisplayConfiguration? = null, // Nested type
    val paymentActionConfiguration: PaymentActionConfiguration? = null, // Nested type

    val fields: Map<String, AccessMatrix>? = null, // Map for Map<String, AccessMatrix>
    val allowBulkOperation: Boolean = false
) {
    // --- Constants ---
    // String constants (public static final String) become const val in companion object
    companion object {
        const val ACTION_TYPE_MODIFY_STATUS = "MODIFY_STATUS"
        const val ACTION_TYPE_REVIEW = "REVIEW"
        const val ACTION_TYPE_ASSIGN = "ASSIGN"
        const val ACTION_TYPE_REPORT = "REPORT"
        const val ACTION_TYPE_SEND_BACK = "SEND_BACK"
        const val ACTION_TYPE_DISCARD = "DISCARD"
        const val ACTION_TYPE_PAYMENT = "PAYMENT"
        const val ACTION_TYPE_CURRENT_ASSIGNEE = "CURRENT_ASSIGNEE"
        const val ACTION_VISIBITY_ADMIN = "ADMIN"
        const val ACTION_VISIBITY_SUPER_ADMIN = "SUPERADMIN"
        const val ACTION_VISIBILITY_ADHOC = "AD_HOC"
        const val ACTION_VISIBILITY_USER = "USER"
        const val ACTION_VISIBILITY_INITIATOR = "INITIATOR"
        const val ACTION_TYPE_TASK = "TASK"
        const val ACTION_TYPE_REFRESH = "REFRESH"
        const val RETRY_COLOR = "#fd464e"
        const val EDIT_COLOR = "#db8f42"
        const val DISCARD_COLOR = "#b76c2d"


        val UPDATE_ACTION_ID = "424f9c40-1659-4daf-9d06-14fddd75f5c2"
        val RETRY_ACTION_ID = "cfeb5f95-b13d-4bb7-ba75-3c2bf6098380"
        val EDIT_ACTION_ID = "720c14be-507a-41d5-952b-df4aed11d997"
        val EDIT_DISCARD_ID = "0b1030de-ab63-4892-a8fe-f81c3aab9d46"
        val TEMP_AUDIT_DISCARD_ID = "0b1030de-ab63-4892-a8fe-f81c3aab9d46"
        val TEMP_REVIEW_DISCARD_ID = "0b1030de-ab63-4892-a8fe-f81c3aab9d46"
    }

    fun isCustomAction(): Boolean {
        return actionId != null && (
                actionId == RETRY_ACTION_ID ||
                        actionId == EDIT_ACTION_ID ||
                        actionId == UPDATE_ACTION_ID
                )
    }

    fun isReviewActionButton(): Boolean {
        return ACTION_TYPE_REVIEW.equals(actionType, ignoreCase = true)
    }

    fun isPaymentActionButton(): Boolean {
        return ACTION_TYPE_PAYMENT.equals(actionType, ignoreCase = true)
    }

    fun isRetryActionButton(): Boolean {
        return actionId != null && actionId == RETRY_ACTION_ID
    }

    fun isRefreshActionButton(): Boolean {
        return ACTION_TYPE_REFRESH.equals(actionType, ignoreCase = true)
    }

}


@kotlinx.serialization.Serializable
data class ActionButtonDisplayConfiguration(
    val fillType: String? = null // e.g., "UNFILLED", "FILLED"
) {
    companion object {
        const val UNFILLED = "UNFILLED"
        const val FILLED = "FILLED"
    }
}