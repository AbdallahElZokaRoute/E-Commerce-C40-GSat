package com.route.domain.repostories

import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    suspend fun getCategories(): Flow<ApiResult<List<CategoryDataItemEntity>>>
}

