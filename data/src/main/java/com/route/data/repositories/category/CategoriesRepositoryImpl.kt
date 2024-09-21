package com.route.data.repositories.category

import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.repostories.CategoriesRepository

class CategoriesRepositoryImpl(
    private val onlineDataSource: CategoriesOnlineDataSource,
) : CategoriesRepository {
    override suspend fun getCategories(): List<CategoryDataItemEntity> {
        return onlineDataSource.fetchCategories()
    }
}
