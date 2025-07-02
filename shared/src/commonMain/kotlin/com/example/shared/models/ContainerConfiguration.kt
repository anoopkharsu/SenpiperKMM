package com.example.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class ContainerConfiguration(
    val backgroundConfiguration: BackgroundConfiguration? = null,
    val textConfiguration: TextConfiguration? = null,
    val spacing: MarginConfiguration? = null
)


@Serializable
data class BackgroundConfiguration(
    val borderThickness: Float? = null,
    val borderColor: String? = null,
  //  val borderRadius: CornerRadius? = null, // Nested data class
    val color: String? = null,
    val shadow: String? = null,
    val imageName: String? = null,
    val imageUrl: String? = null,
    val drawableStart: Int = 0 // Android resource ID, default to 0
) {
    companion object {
        const val FIELD_BACKGROUND_9_PATCH = "field_background_9_patch"
        const val FIELD_BACKGROUND_THICKER_SHADOWS_9_PATCH = "field_background_thicker_shadows_9_patch"
    }
}

@Serializable
data class TextConfiguration(
    val text: String? = null,
    val placeholderTextConfiguration: TextConfiguration? = null,
    val selectAllTextConfiguration: TextConfiguration? = null,
    val fontConfiguration: FontConfiguration? = null,
    val prefixConfiguration: ContainerConfiguration? = null,
    val suffixConfiguration: ContainerConfiguration? = null,
    val numberOfLines: Int? = null,
    val textAlignment: String? = null
) {
    companion object {
        const val LEFT = "left"
        const val RIGHT = "right"
        const val CENTER = "center"
    }
}

@Serializable
data class FontConfiguration(
    val fontSize: String? = null, // small/medium/large
    val fontWeight: String? = null,  //regular/medium/light
    val fontColor: String? = null,
    val fontStyle: String? = null  //normal/bold/italic/bold_italic
)


@Serializable
data class MarginConfiguration(
    val left: Int? = null,
    val top: Int? = null,
    val bottom: Int? = null,
    val right: Int? = null
)