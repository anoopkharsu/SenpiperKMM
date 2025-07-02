package com.example.shared.preferences

// All imports should be here, at the top
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferenceDataStoreFactory // Moved this line up
import okio.Path.Companion.toPath // Moved this line up

// Define a typealias for clarity, making it easy to change if needed.
// This is the name of our settings file.
private const val SETTINGS_FILE_NAME = "app_settings.preferences_pb"

// This is our expected factory function.
// It will be implemented differently on Android and iOS.
internal expect fun createDataStore(): DataStore<Preferences>

// You can create a singleton holder to easily access the DataStore from anywhere
// in your common code.
object AppDataStore {
    val dataStore: DataStore<Preferences> by lazy {
        createDataStore()
    }
}

// ... (keep the other common code)

// This helper function can be in the same commonMain file
// It uses Okio to handle file paths in a multiplatform way
internal fun createDataStore(producePath: () -> String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}