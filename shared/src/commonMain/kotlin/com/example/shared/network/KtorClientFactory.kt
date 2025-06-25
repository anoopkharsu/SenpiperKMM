package com.senpiper.android.network

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun createClient(): HttpClient
}
//
//import io.ktor.client.HttpClient
//import io.ktor.client.plugins.DefaultRequest
//import io.ktor.client.plugins.HttpTimeout
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.request.header
//import io.ktor.http.ContentType
//import io.ktor.http.HttpHeaders // Required for HttpHeaders.Authorization
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.serialization.json.Json
//
///**
// * Singleton object responsible for initializing and providing the Ktor HttpClient.
// * It allows the base URL to be set dynamically from the platform layer
// * and automatically adds an authentication token to requests if available.
// */
//object KtorClient {
//
//
//    private lateinit var _httpClient: HttpClient
//
//
//    val client: HttpClient
//        get() = _httpClient
//
//
//    var authToken: String? = ""
//
//    fun init(baseUrl: String) {
//        // Prevent re-initialization if already set up.
//        if (::_httpClient.isInitialized) {
//            println("ApiClient already initialized with base URL: ${baseUrl}. Skipping re-initialization.")
//            return
//        }
//
//        _httpClient = HttpClient {
//
//            install(ContentNegotiation) {
//                json(Json {
//                    prettyPrint = true
//                    isLenient = true
//                    ignoreUnknownKeys = true
//                    coerceInputValues = true
//                })
//            }
//
//            install(DefaultRequest) {
//                url(baseUrl) // Set the base URL for all requests.
//                header(HttpHeaders.ContentType, ContentType.Application.Json) // Default content type for requests.
//
//                authToken?.let { token ->
//                    header(HttpHeaders.Authorization, "Bearer $token")
//                }
//            }
//
//            install(HttpTimeout) {
//                requestTimeoutMillis = 15000 // Total timeout for a single request (connect + receive).
//                connectTimeoutMillis = 15000 // Timeout for establishing a connection to the server.
//                socketTimeoutMillis = 15000  // Timeout for inactivity during data transfer.
//            }
//
//
//        }
//    }
//
//
//    fun updateAuthToken(token: String?) {
//        this.authToken = token
//        println("Auth token updated to: ${if (token != null) "SET" else "NULL"}")
//    }
//}