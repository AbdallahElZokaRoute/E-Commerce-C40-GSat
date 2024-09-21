package com.route.data.dataSource.di

import com.route.data.dataSource.online.api.auth.AuthOnlineDataSourceImpl
import com.route.data.dataSource.online.api.auth.AuthService
import com.route.data.dataSource.online.api.category.CategoriesOnlineDataSourceImpl
import com.route.data.dataSource.online.api.category.CategoriesService
import com.route.data.repositories.auth.AuthRepositoryImpl
import com.route.data.repositories.category.CategoriesRepositoryImpl
import com.route.domain.dataSource.AuthOnlineDataSource
import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.repostories.AuthRepository
import com.route.domain.repostories.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    @Singleton
    fun bindsCategoriesOnlineDataSource(
        categoriesService: CategoriesService
    ): CategoriesOnlineDataSource {
        return CategoriesOnlineDataSourceImpl(categoriesService)
    }

    @Provides
    @Singleton
    fun providesCategoriesRepository(
        onlineDataSource: CategoriesOnlineDataSource
    ): CategoriesRepository {
        return CategoriesRepositoryImpl(onlineDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthOnlineDataSource(service: AuthService): AuthOnlineDataSource {
        return AuthOnlineDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(onlineDataSource: AuthOnlineDataSource): AuthRepository {
        return AuthRepositoryImpl(onlineDataSource)
    }
}
