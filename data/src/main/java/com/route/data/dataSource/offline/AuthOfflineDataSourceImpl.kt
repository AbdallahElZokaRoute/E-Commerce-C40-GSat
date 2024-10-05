package com.route.data.dataSource.offline

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.route.domain.dataSource.AuthOfflineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AuthOfflineDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : AuthOfflineDataSource {
    override suspend fun saveToken(token: String) {
        dataStore.edit { settings ->
            settings[stringPreferencesKey("token")] = token
        }
    }

    override suspend fun getToken(): String {
        return dataStore.data.map { settings ->
            settings[stringPreferencesKey("token")] ?: ""
        }.first()
    }

}