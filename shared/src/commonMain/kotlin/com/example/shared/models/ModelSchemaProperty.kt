package com.example.shared.models



import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class ModelSchemaProperty(
    // UUIDs should be represented as Strings for KMM serialization
    val formId: String? = null,
    val groupId: String? = null,

    val title: String? = null,
    val type: String? = null,
    val description: String? = null,
    val uri: String? = null,
    val fieldName: String? = null,
    // fieldSHA1Key is usually derived, so it might not be directly in JSON.
    // If it *can* be in JSON, include it. If it's *always* derived, make it a custom getter.
    val fieldSHA1Key: String? = null,
    val fieldCompositeKey: String? = null,
    val format: String? = null,
    val timeUnit: String? = null,
    val userProfileDriven: Boolean = false, // Boolean defaults to false
    val userProfileKey: String? = null,
    val maxRows: Int? = null,
    val minRows: Int? = null,
    val editable: Boolean = false, // Boolean defaults to false
    val pickManually: Boolean = false, // Boolean defaults to false
    val notRequiredMasterCaching: Boolean = false, // Boolean defaults to false
    val masterRequestOngoing: Boolean = false, // Boolean defaults to false
    val previousMasterApiCompleteDataReceived: Boolean = false, // Boolean defaults to false
    val enableOfflineOptionFilterMaster: Boolean? = null, // Boolean? for explicit null
    val filterStringExpression: String? = null,
    val hideSearchIcon: Boolean = false, // Boolean defaults to false
    val disableManualEntry: Boolean = false, // Boolean defaults to false
    val enableOnlineSearchableMaster: Boolean = false, // Boolean defaults to false
    val excludedFieldsForCopiedRow: List<String>? = null,
    val otpValidation: String? = null,
    val remoteValidation: Boolean = false, // Boolean defaults to false

    val remoteValidations: List<RemoteValidations>? = null, // Nested type
    val otpConfig: OTPConfig? = null, // Nested type
    val placeholder: String? = null,
    val titleDisplayConfiguration: TitleDisplayConfiguration? = null, // Nested type
    val rowHeaderDisplayConfiguration: RowHeaderDisplayConfiguration? = null, // Nested type
    val singleSelectAnswer: String? = null,
    val decideSectionRendering: Boolean = false, // Boolean defaults to false
    val isSelected: Boolean? = null, // Boolean? for explicit null
//    val multiSelectAnswer: List<Any>? = null, // Use List<Any> as type is unknown; might need custom serializer or more specific type if known
    val validation: Boolean? = null, // Marked as @JsonIgnore in Java, but has getter/setter. Including for serialization.
    val dateOnly: Boolean? = null,
    val timeOnly: Boolean? = null,
    val self: Boolean? = null,
    val systemTime: Boolean? = null,
    val dateandtime: Boolean? = null,
    @Deprecated("multi is deprecated") // Kotlin equivalent of Java's @Deprecated
    val multi: Boolean? = null,
    val readOnly: Boolean? = null, // Marked as @JsonIgnore in Java, but has getter/setter. Including for serialization.
    val requiredField: Boolean? = null,
    val hideSyncMasterStrip: Boolean? = null,
    val hint: String? = null,
    val multiValuedList: List<MultiValue>? = null, // Nested type
    val items: ModelSchemaProperty? = null, // Recursive type!
    val order: List<String>? = null,
    val keysForRowHeader: List<String>? = null,
    val dependentKeys: List<String>? = null,
    val pattern: String? = null,
    val masterDataPojos: List<JsonElement>? = null, // Use JsonElement for generic Objects
    val masterId: String? = null, // UUID as String
    val masterName: String? = null,
    val lastMasterDataSyncTimeStamp: Long? = null,
    val masterDataCache: List<JsonElement>? = null, // Use JsonElement for generic Objects
    val predicates: List<Predicate>? = null, // Nested type
    val initialArrayAnswerCount: Int = 0, // Int defaults to 0
    val caseIdentifierKey: String? = null,
    val fieldTypeArray: Boolean = false, // Boolean defaults to false
    val locationMandatory: Boolean = false, // Boolean defaults to false
    val searchQueryConfiguration: SearchQueryConfiguration? = null, // Nested type
    val comparatorType: Operator? = null, // Nested type (likely an enum or string)
    val properties: Map<String, ModelSchemaProperty>? = null, // Recursive type map
    val required: List<String>? = null,
    val searchableKeys: List<String>? = null,
    val maxSize: Int? = null,
    val disableFilepicker: Boolean? = null,
    val embedImageMetadata: Boolean? = null,
    val showGeoCoordinates: Boolean? = null,
    val validationMessage: String? = null,
    val enableEventScheduling: Boolean? = null,
    val shouldNotAutoDismissCameraView: Boolean = false, // Boolean defaults to false
    val layout: String? = null,
    val defaultValue: JsonElement? = null, // Use JsonElement for generic Object
    val localisationMap: Map<String, Map<String, JsonElement>>? = null, // HashMap<String, HashMap<String, Object>>
    val newRowLabel: String? = null,
    val horizontalView: Boolean = false, // Boolean defaults to false
    val multimediaType: String? = null,
    val filterString: String? = null,
    val lastTimeMasterWasSynced: Long? = null,
    val sourceAnswer: JsonElement? = null, // Use JsonElement for generic Object
    val previewFields: List<String>? = null,
    val name: String? = null,
    val columnKey: String? = null,
    val columnName: String? = null,
    val masterType: String? = null,
    @SerialName("enum") // Map "enum" JSON key to enumList Kotlin property
    val enumList: List<String>? = null,
    val localisedStatuses: List<String>? = null,
    val localisedPriorities: List<String>? = null,
    val maximum: Int? = null, // Using Int? for Integer
    val minimum: Int? = null, // Using Int? for Integer
    val position: Int? = null, // Using Int? for Integer
    val cameraOnly: Boolean? = null,
    val enforceCameraFlash: Boolean? = null,
    val useLastValue: Boolean? = null,
    val multimediaConfig: MultimediaConfig? = null, // Nested type
    val sortOptions: Boolean? = null,
    val minSize: Int? = null, // Using Int? for Integer
    val accessMatrix: AccessMatrix? = null, // Nested type
    val originalAccessMatrix: AccessMatrix? = null, // Nested type
    // displayFieldTitle was @JsonIgnore and doesn't have a setter, indicating it's derived.
    // It's not part of the primary constructor.
    val formReportConfiguration: FormReportConfiguration? = null, // Nested type
    val prefilledDataMappingKey: String? = null,
    val scanDisplayValueForBarCode: Boolean = false, // Boolean defaults to false
    val isMasterApplied: Boolean = false, // Boolean defaults to false
    val separatedInputConfiguration: List<SeparatedInputConfiguration>? = null, // Nested type
    val hideAddNewRowButton: Boolean? = null,

    val formDisplayConfiguration: FieldDisplayConfiguration? = null, // Nested type
    val viewModeConfiguration: FieldDisplayConfiguration? = null, // Nested type
    val fillModeConfiguration: FieldDisplayConfiguration? = null, // Nested type
    val renderAsMd: Boolean = false, // Boolean defaults to false
    val mdEnumListLocalisationMap: Map<String, Map<String, JsonElement>>? = null, // HashMap<String, HashMap<String, Object>>

    val prefixText: String? = null,
    val suffixText: String? = null,
    val selectAllButtonText: String? = null,
    val masterConfiguration: MasterConfiguration? = null, // Nested type

    val enableClientSideValidateButton: Boolean? = null,

    val originalImage: ModelSchemaProperty? = null, // Recursive type
    val transformedImage: ModelSchemaProperty? = null, // Recursive type
    val dimensionValue: ModelSchemaProperty? = null, // Recursive type
    val isDetected: ModelSchemaProperty? = null, // Recursive type

    val validationStatus: Boolean? = null, // Boolean? for explicit null

    val cameraHint: String? = null
) {
    // Companion object for constants
    companion object {
        const val REQUESTED = "REQUESTED"
        const val MANDATORY = "MANDATORY"
        // serialVersionUID is not needed in Kotlinx Serialization context
    }

}


@Serializable
data class OTPConfig(
    val enabled: Boolean = false,
    val digits: Int? = null,
    val expiryTimeSeconds: Int? = null
    // ... add other OTP related properties
)

@Serializable
enum class Operator {
    EQUALS,
    NOT_EQUALS,
    GREATER_THAN,
    LESS_THAN,
    // ... add all other operators from your API
}
@Serializable
data class RemoteValidations(
    val populateAnswer: Boolean? = null,
    val validateOnly: Boolean? = null,
    val buttonConfiguration: ButtonConfiguration? = null,
    val dataSource: String? = null,
    val externalApiValidationConfig: ExternalApiValidationConfig? = null,
)


@Serializable
data class MultiValue(
    val primary: String? = null,
    val secondary: String? = null,
    val tertiary: String? = null
)

@Serializable
data class SeparatedInputConfiguration(
    var prefix : String? = null,
    var inputLength : Int? = null,
    var suffix : String? = null
)

@Serializable
data class ExternalApiValidationConfig(
    val remoteIntegrationConfig: RemoteIntegrationConfig? = RemoteIntegrationConfig(),
)

@Serializable
data class RemoteIntegrationConfig(
    val dataStoreId: String? = null,
    val httpsConnectorConfiguration: HttpsConnectorConfiguration? = null,
    val requestBodyMapperMap: RequestBodyMapperMap? = null,
    val senpiperObjectPopulationConfig: SenpiperObjectPopulationConfig? = null,
)
@Serializable
data class HttpsConnectorConfiguration(
    val apiEndPoint: String? = null,
    val contentType: String? = null,
//    val generateRequestMethod: Any? = null,
    val headerMap: HeaderMap? = null,
    val requestMethod: String? = null,
    val useSecondaryDataObjectForParameters: Boolean? = null,
)

@Serializable
data class RequestBodyMapperMap(
    @SerialName("FormAnswer")
    val formAnswer: FormAnswer? = null,
)

@Serializable
data class SenpiperObjectPopulationConfig(
    val actionValue: ActionValue? = null,
    val authConfig: AuthConfig? = null,
    val senpiperObjectType: String? = null,
)

@Serializable
data class HeaderMap(
    val contentType: String? = null,
)

@Serializable
data class FormAnswer(
    val senpiperObjectNameForIntegrationBody: String? = null,
    val shouldUseSenpiperObjectForIntegration: Boolean? = null,
)

@Serializable
data class ActionValue(
    val value: String? = null,
    val remark: String? = null,
    val answer: Map<String, JsonElement>? = null, // Map<String, JsonElement> for generic Map
    val status: String? = null,
    val actionType: String? = null,
    val orderId: String? = null,
    val paymentId: String? = null
)

@Serializable
data class AuthConfig(
    val authCaller: String? = null,
    val authId: String? = null,
)