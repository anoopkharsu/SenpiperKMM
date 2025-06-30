package com.senpiper.android.network

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun createClient(): HttpClient
}