package com.route.domain.repostories

import com.route.domain.entity.category.CategoryDataItemEntity

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoryDataItemEntity>
}

