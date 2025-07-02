package com.example.shared.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import okio.Path.Companion.toPath

private const val SETTINGS_FILE_NAME = "app_settings.preferences_pb"
private lateinit var dataStoreInstance: DataStore<Preferences>

// Initializer function to be called from the Android App class
fun initDataStore(context: Context) {
    dataStoreInstance = createDataStore(
        producePath = { context.filesDir.resolve(SETTINGS_FILE_NAME).absolutePath }
    )
}

// The actual implementation for Android
internal actual fun createDataStore(): DataStore<Preferences> {
    if (::dataStoreInstance.isInitialized) {
        return dataStoreInstance
    } else {
        error("DataStore has not been initialized. Call initDataStore() from your Application class.")
    }
}