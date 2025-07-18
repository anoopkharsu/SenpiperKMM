package com.example.composeui.ui


import com.example.shared.network.KMMSPNetwork

object KMMBridge {
    fun initializeNetwork(baseUrl: String) {
        KMMSPNetwork.instance.initialize(baseUrl)
    }

    suspend fun fetchCompanyConfig(domain: String): String {
        return KMMSPNetwork.instance.fetchCompanyConfig(domain).response.toString()
    }
}