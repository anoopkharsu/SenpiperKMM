package com.example.shared.preferences

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDefaults {
    // Get the DataStore instance from our singleton
    private val dataStore = AppDataStore.instance

    private class Keys {
        companion object {
            val SERVERURL = stringPreferencesKey("serverUrl")
            val TOKEN = stringPreferencesKey("token")
            val LOGIN_STATE = stringPreferencesKey("loginState")
            val FCM_DEVICE_TOKEN = stringPreferencesKey("fcmDeviceToken")
            val SESSION_ID = stringPreferencesKey("sessionId")
            val FORM_ANSWER_OTP_SESSION_ID = stringPreferencesKey("formAnswerOtpSessionId")
            val SIGN_UP_SESSION_ID = stringPreferencesKey("signUpSessionId")
            val USER_NAME = stringPreferencesKey("userName")
            val USER_ID = stringPreferencesKey("userId")
            val EMAIL = stringPreferencesKey("email")
            val ROLE = stringPreferencesKey("role")
            val PHONE = stringPreferencesKey("phone")
            val STORED_ENV = stringPreferencesKey("storedEnv")
            val IMAGE_URL = stringPreferencesKey("imageUrl")
            val UNIQUE_DEVICE_ID = stringPreferencesKey("uniqueDeviceId")
            val KEYCHAIN_LOGIN_KEY = stringPreferencesKey("keychainLoginKey")
            val KEYCHAIN_LOGIN_TYPE = stringPreferencesKey("keychainLoginType")
        }
    }

    val serverURLFlow: Flow<String> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.SERVERURL] ?: "Guest"
    }

    val tokenFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.TOKEN]
    }

    val serverUrlFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.SERVERURL]
    }

    val loginStateFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.LOGIN_STATE]
    }

    val fcmDeviceTokenFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.FCM_DEVICE_TOKEN]
    }

    val sessionIdFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.SESSION_ID]
    }

    val formAnswerOtpSessionIdFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.FORM_ANSWER_OTP_SESSION_ID]
    }

    val signUpSessionIdFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.SIGN_UP_SESSION_ID]
    }

    val userNameFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.USER_NAME]
    }

    val userIdFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.USER_ID]
    }

    val emailFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.EMAIL]
    }

    val roleFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.ROLE]
    }

    val phoneFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.PHONE]
    }

    val storedEnvFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.STORED_ENV]
    }

    val imageUrlFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.IMAGE_URL]
    }

    val uniqueDeviceIdFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.UNIQUE_DEVICE_ID]
    }

    val keychainLoginKeyFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.KEYCHAIN_LOGIN_KEY]
    }

    val keychainLoginTypeFlow: Flow<String?> = dataStore.dataStore.data.map { preferences ->
        preferences[Keys.KEYCHAIN_LOGIN_TYPE]
    }

    suspend fun saveServerURL(url: String) {
        dataStore.dataStore.edit { preferences ->
            preferences[Keys.SERVERURL] = url
        }
    }

    suspend fun saveToken(token: String?) {
        dataStore.dataStore.edit { preferences ->
            if (token != null) {
                preferences[Keys.TOKEN] = token
            } else {
                preferences.remove(Keys.TOKEN)
            }
        }
    }

    suspend fun saveServerUrl(serverUrl: String?) {
        dataStore.dataStore.edit { preferences ->
            if (serverUrl != null) {
                preferences[Keys.SERVERURL] = serverUrl
            } else {
                preferences.remove(Keys.SERVERURL)
            }
        }
    }

    suspend fun saveLoginState(loginState: String?) {
        dataStore.dataStore.edit { preferences ->
            if (loginState != null) {
                preferences[Keys.LOGIN_STATE] = loginState
            } else {
                preferences.remove(Keys.LOGIN_STATE)
            }
        }
    }

    suspend fun saveFcmDeviceToken(fcmDeviceToken: String?) {
        dataStore.dataStore.edit { preferences ->
            if (fcmDeviceToken != null) {
                preferences[Keys.FCM_DEVICE_TOKEN] = fcmDeviceToken
            } else {
                preferences.remove(Keys.FCM_DEVICE_TOKEN)
            }
        }
    }

    suspend fun saveSessionId(sessionId: String?) {
        dataStore.dataStore.edit { preferences ->
            if (sessionId != null) {
                preferences[Keys.SESSION_ID] = sessionId
            } else {
                preferences.remove(Keys.SESSION_ID)
            }
        }
    }

    suspend fun saveFormAnswerOtpSessionId(formAnswerOtpSessionId: String?) {
        dataStore.dataStore.edit { preferences ->
            if (formAnswerOtpSessionId != null) {
                preferences[Keys.FORM_ANSWER_OTP_SESSION_ID] = formAnswerOtpSessionId
            } else {
                preferences.remove(Keys.FORM_ANSWER_OTP_SESSION_ID)
            }
        }
    }

    suspend fun saveSignUpSessionId(signUpSessionId: String?) {
        dataStore.dataStore.edit { preferences ->
            if (signUpSessionId != null) {
                preferences[Keys.SIGN_UP_SESSION_ID] = signUpSessionId
            } else {
                preferences.remove(Keys.SIGN_UP_SESSION_ID)
            }
        }
    }

    suspend fun saveUserName(userName: String?) {
        dataStore.dataStore.edit { preferences ->
            if (userName != null) {
                preferences[Keys.USER_NAME] = userName
            } else {
                preferences.remove(Keys.USER_NAME)
            }
        }
    }

    suspend fun saveUserId(userId: String?) {
        dataStore.dataStore.edit { preferences ->
            if (userId != null) {
                preferences[Keys.USER_ID] = userId
            } else {
                preferences.remove(Keys.USER_ID)
            }
        }
    }

    suspend fun saveEmail(email: String?) {
        dataStore.dataStore.edit { preferences ->
            if (email != null) {
                preferences[Keys.EMAIL] = email
            } else {
                preferences.remove(Keys.EMAIL)
            }
        }
    }

    suspend fun saveRole(role: String?) {
        dataStore.dataStore.edit { preferences ->
            if (role != null) {
                preferences[Keys.ROLE] = role
            } else {
                preferences.remove(Keys.ROLE)
            }
        }
    }

    suspend fun savePhone(phone: String?) {
        dataStore.dataStore.edit { preferences ->
            if (phone != null) {
                preferences[Keys.PHONE] = phone
            } else {
                preferences.remove(Keys.PHONE)
            }
        }
    }

    suspend fun saveStoredEnv(storedEnv: String?) {
        dataStore.dataStore.edit { preferences ->
            if (storedEnv != null) {
                preferences[Keys.STORED_ENV] = storedEnv
            } else {
                preferences.remove(Keys.STORED_ENV)
            }
        }
    }

    suspend fun saveImageUrl(imageUrl: String?) {
        dataStore.dataStore.edit { preferences ->
            if (imageUrl != null) {
                preferences[Keys.IMAGE_URL] = imageUrl
            } else {
                preferences.remove(Keys.IMAGE_URL)
            }
        }
    }

    suspend fun saveUniqueDeviceId(uniqueDeviceId: String?) {
        dataStore.dataStore.edit { preferences ->
            if (uniqueDeviceId != null) {
                preferences[Keys.UNIQUE_DEVICE_ID] = uniqueDeviceId
            } else {
                preferences.remove(Keys.UNIQUE_DEVICE_ID)
            }
        }
    }

    suspend fun saveKeychainLoginKey(keychainLoginKey: String?) {
        dataStore.dataStore.edit { preferences ->
            if (keychainLoginKey != null) {
                preferences[Keys.KEYCHAIN_LOGIN_KEY] = keychainLoginKey
            } else {
                preferences.remove(Keys.KEYCHAIN_LOGIN_KEY)
            }
        }
    }

    suspend fun saveKeychainLoginType(keychainLoginType: String?) {
        dataStore.dataStore.edit { preferences ->
            if (keychainLoginType != null) {
                preferences[Keys.KEYCHAIN_LOGIN_TYPE] = keychainLoginType
            } else {
                preferences.remove(Keys.KEYCHAIN_LOGIN_TYPE)
            }
        }
    }

    suspend fun clearAll() {
        dataStore.dataStore.edit { it.clear() }
    }
}