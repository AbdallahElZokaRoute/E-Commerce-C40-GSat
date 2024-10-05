package com.route.data.repositories.category

import com.route.data.dataSource.online.api.category.CategoriesOnlineDataSourceImpl
import com.route.domain.dataSource.CategoriesOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.repostories.CategoriesRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class CategoriesRepositoryImplTest {

    @Test
    fun `fetchCategories() call Online DataSource function then should Invoke Once`() = runTest {
        // Main Thread
        val onlineDataSource: CategoriesOnlineDataSource = mockk<CategoriesOnlineDataSourceImpl>()
        val categories = listOf(
            CategoryDataItemEntity(),
            CategoryDataItemEntity(),
            CategoryDataItemEntity(),

            )
        coEvery { onlineDataSource.fetchCategories() } returns flow {
            emit(ApiResult.Success(categories))
        }

        val repository = CategoriesRepositoryImpl(onlineDataSource)
        val result = repository.getCategories()
        coVerify(exactly = 1) {
            onlineDataSource.fetchCategories()
        }
    }

    @Test
    fun `fetchCategories() emit Loading then success`() = runTest {
        // Main Thread                 // Thread => Main thread
        val onlineDataSource: CategoriesOnlineDataSource = mockk<CategoriesOnlineDataSourceImpl>()
        val categories = listOf(
            CategoryDataItemEntity(),
            CategoryDataItemEntity(),
            CategoryDataItemEntity(),

            )
        coEvery { onlineDataSource.fetchCategories() } returns flow {
            emit(ApiResult.Loading(showLoading = true))
            emit(ApiResult.Success(categories))
        }

        val repository = CategoriesRepositoryImpl(onlineDataSource)
        val result = repository.getCategories()
        result.collect {

        }
        assertEquals(
            result.first(),
            ApiResult.Loading<List<CategoryDataItemEntity>>(showLoading = true)
        )
    }
}


