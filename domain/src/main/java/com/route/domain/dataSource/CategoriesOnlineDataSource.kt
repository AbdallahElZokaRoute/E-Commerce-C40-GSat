package com.route.domain.dataSource

import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import kotlinx.coroutines.flow.Flow

interface CategoriesOnlineDataSource {
    suspend fun fetchCategories(): Flow<ApiResult<List<CategoryDataItemEntity>>>
}


interface CategoriesOfflineDataSource

