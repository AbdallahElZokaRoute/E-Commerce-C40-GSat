package com.route.data.repositories.category

import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.repostories.CategoriesRepository
import kotlinx.coroutines.flow.Flow

class CategoriesRepositoryImpl(
    private val onlineDataSource: CategoriesOnlineDataSource,
) : CategoriesRepository {
    override suspend fun getCategories(): Flow<ApiResult<List<CategoryDataItemEntity>>> {
        return onlineDataSource.fetchCategories()
    }
}
