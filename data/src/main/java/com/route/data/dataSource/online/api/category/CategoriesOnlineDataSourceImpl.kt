package com.route.data.dataSource.online.api.category

import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.entity.category.CategoryDataItemEntity

class CategoriesOnlineDataSourceImpl(
    private val service: CategoriesService
) : CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): List<CategoryDataItemEntity> {
        return service.fetchCategories().data?.map {
            it.toEntity()
        } ?: listOf()
    }

}