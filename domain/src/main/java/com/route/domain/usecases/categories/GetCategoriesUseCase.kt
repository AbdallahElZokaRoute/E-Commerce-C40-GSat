package com.route.domain.usecases.categories

import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.repostories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    suspend operator fun invoke(): Flow<ApiResult<List<CategoryDataItemEntity>>> {
        return repository.getCategories()
    }

}
