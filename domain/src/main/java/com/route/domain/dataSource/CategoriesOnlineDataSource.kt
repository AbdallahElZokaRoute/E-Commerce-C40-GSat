package com.route.domain.dataSource

import com.route.domain.entity.category.CategoryDataItemEntity

interface CategoriesOnlineDataSource {
    suspend fun fetchCategories(): List<CategoryDataItemEntity>
}


interface CategoriesOfflineDataSource

