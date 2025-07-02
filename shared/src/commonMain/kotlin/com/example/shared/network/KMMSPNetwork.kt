package com.example.shared.network

import com.example.shared.models.SPResult
import com.senpiper.android.network.KtorClientFactory

object KMMSPNetwork {

    private val client = KtorClientFactory().createClient()
    private var ktorService: KtorService? = null

    fun initialize(baseUrl: String) {
        ktorService = KtorService(client, baseUrl)
    }

    private fun getService(): KtorService {
        return ktorService ?: throw IllegalStateException("SPNetwork is not initialized. Please call initialize(baseUrl) first.")
    }

    suspend fun fetchCompanyConfig(domainName: String): SPResult {
        return getService().fetchCompanyConfig(domainName)
    }
} 