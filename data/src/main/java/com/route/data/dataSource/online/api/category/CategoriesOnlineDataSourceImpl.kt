package com.route.data.dataSource.online.api.category

import com.route.data.executeAPI
import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import kotlinx.coroutines.flow.Flow

class CategoriesOnlineDataSourceImpl(
    private val service: CategoriesService
) : CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): Flow<ApiResult<List<CategoryDataItemEntity>>> {
        return executeAPI {
            service.fetchCategories().data?.map { it.toEntity() } ?: listOf()
        }
    }

}