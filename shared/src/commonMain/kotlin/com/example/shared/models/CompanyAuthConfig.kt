package com.example.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class CompanyAuthConfig(
    val signUpAllowed: Boolean = false,
    val signUpConfig: SignUpConfig? = null,
    val passwordConfig: PasswordConfig? = null,
    val allowPartiallyRegisteredUsers: Boolean = false,
    val allowPasswordResetOnAccountLock: Boolean = false,
    val ssoConfigs: List<SSOConfigs>? = null,
    val secretType: String? = null,
    val biometricAuthConfig: BiometricAuthConfig? = null,
    val signInOrder: List<String>? = null,
    val passwordExpiryTimeInDays: Int? = null,
    val hideOneResourceBranding: Boolean = false,
    val maxInvalidLoginAttemptLimit: Int? = null
) {
    companion object {
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
        const val PASSWORD = "PASSWORD"
        const val OTP = "OTP"
        const val MFA = "MFA"
        const val ADFS = "ADFS"
    }
}

@Serializable
data class SignUpConfig(
    val signUpSchema: ModelSchemaProperty? = null,
    val signUpButton: Action? = null,
    val verifyOn: List<String>? = null
)

@Serializable
data class PasswordConfig(
    val minLength: Int? = null,
    val maxLength: Int? = null,
    val requiresUppercase: Boolean = false,
    val requiresLowercase: Boolean = false,
    val requiresDigit: Boolean = false,
    val requiresSpecialChar: Boolean = false
)

@Serializable
data class SSOConfigs(
    val provider: String? = null,
    val clientId: String? = null,
    val clientSecret: String? = null
)

@Serializable
data class BiometricAuthConfig(
    val enabled: Boolean = false,
    val biometricType: String? = null
)