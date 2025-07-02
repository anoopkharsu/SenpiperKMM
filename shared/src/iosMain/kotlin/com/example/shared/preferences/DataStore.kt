package com.example.shared.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

private const val SETTINGS_FILE_NAME = "app_settings.preferences_pb"

// The actual implementation for iOS
internal actual fun createDataStore(): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            val documentDirectory = NSSearchPathForDirectoriesInDomains(
                NSDocumentDirectory,
                NSUserDomainMask,
                true
            ).first() as String
            // Here we use the path to create the file in the documents directory.
            "$documentDirectory/$SETTINGS_FILE_NAME"
        }
    )
}