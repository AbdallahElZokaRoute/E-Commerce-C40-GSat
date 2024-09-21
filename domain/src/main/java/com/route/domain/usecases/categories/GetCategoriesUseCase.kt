package com.route.domain.usecases.categories

import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.repostories.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    suspend operator fun invoke(): List<CategoryDataItemEntity> {
        return repository.getCategories()
    }

}
