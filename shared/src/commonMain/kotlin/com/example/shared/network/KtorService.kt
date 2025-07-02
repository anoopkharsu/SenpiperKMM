package com.example.shared.network

import com.example.shared.models.SPResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import io.ktor.http.takeFrom

class KtorService(
    private val client: HttpClient,
    private val baseUrl: String
) {

    suspend fun fetchCompanyAuthConfig(subDomain: String): SPResult {

        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api", "core", "companies", "config", subDomain)
            }
        }.body()

    }

}
