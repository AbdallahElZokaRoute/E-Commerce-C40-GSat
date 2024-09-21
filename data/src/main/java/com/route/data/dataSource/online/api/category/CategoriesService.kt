package com.route.data.dataSource.online.api.category

import com.route.data.models.categories.CategoriesResponse
import retrofit2.http.GET

interface CategoriesService {
    @GET("categories")
    suspend fun fetchCategories(): CategoriesResponse
    // Concurrency vs Parallism
    // A   B   C
    // 1 IO Thread

    //   IO Thread
    // 3 APIs

}
