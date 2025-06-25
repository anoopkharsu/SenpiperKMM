package com.example.shared.models


import kotlinx.serialization.Serializable

@Serializable
data class FieldDisplayConfiguration(
    val key: String? = null,
    val hideMenuIcon: Boolean = false,
    val voiceInputEnabled: Boolean = false,
    val renderAsMd: Boolean? = null,
    val fieldContainerConfiguration: ContainerConfiguration? = null,
    val displayOrientation: DisplayOrientationConfiguration? = null,
    val titleConfiguration: ContainerConfiguration? = null,
    val descriptionConfiguration: ContainerConfiguration? = null,
    val errorConfiguration: ContainerConfiguration? = null,
    val valueConfiguration: ContainerConfiguration? = null,
    val fieldSelectedConfiguration: ContainerConfiguration? = null,
    val fieldUnSelectedConfiguration: ContainerConfiguration? = null,
    val addAnotherButtonConfiguration: ContainerConfiguration? = null,
    val buttonConfig: ButtonConfiguration? = null
)