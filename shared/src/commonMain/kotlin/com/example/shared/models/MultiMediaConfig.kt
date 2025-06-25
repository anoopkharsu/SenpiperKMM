package com.example.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class MultimediaConfig(
    // Boolean properties generally default to 'false' if not present in JSON,
    // which is a common and safe default for feature flags.
    val detectFace: Boolean = false,
    val preventRotation: Boolean = false,
    val useFrontCameraOnly: Boolean = false,
    val removeFromLocalStorageAfterSubmission: Boolean = false,
    val faceDetectionConfig: FaceDetectionConfig? = null, // Nested data class
    val compressionPercentage: Int? = null, // Integer in Java maps to Int? for nullability
    val disableCropping: Boolean? = null // Boolean? if it can be explicitly null or absent
)
@Serializable
data class FaceDetectionConfig(
    // Boolean properties are given a default of 'false' if not present in JSON.
    val smiling: Boolean = false,
    val livelinessMandatory: Boolean = false,
    val leftEyeMandatoryOpen: Boolean = false,
    val rightEyeMandatoryOpen: Boolean = false,
    val showOverlay: Boolean = false,
    val detectMask: Boolean = false,
    val autoCapture: Boolean = false,
    // Double properties are nullable and default to 'null' if not present.
    val minSmilingProbability: Double? = null,
    val minFaceToCameraAreaRatio: Double? = null,
    val matchThreshold: Double? = null,
    val prepareEncodingAtClient: Boolean = false
)