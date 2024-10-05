package com.route.domain.dataSource

interface AuthOfflineDataSource {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String
}