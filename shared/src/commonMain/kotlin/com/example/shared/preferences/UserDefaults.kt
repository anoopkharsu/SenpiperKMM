package com.example.shared.preferences

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserDefaults {
    // Get the DataStore instance from our singleton
    private val dataStore = AppDataStore.dataStore

    private class Keys {
        companion object {
            val SERVERURL = stringPreferencesKey("serverUrl")
        }
    }

    val serverURLFlow: Flow<String> = dataStore.data.map { preferences ->
        preferences[Keys.SERVERURL] ?: "Guest"
    }

    suspend fun saveServerURL(url: String) {
        dataStore.edit { preferences ->
            preferences[Keys.SERVERURL] = url
        }
    }

    suspend fun clearAll() {
        dataStore.edit { it.clear() }
    }
}