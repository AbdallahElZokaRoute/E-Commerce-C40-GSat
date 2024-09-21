package com.route.domain.entity.category

data class CategoriesResponseEntity(
    val categoryMetadataEntity: CategoryMetadataEntity? = null,
    val data: List<CategoryDataItemEntity>? = null,
    val results: Int? = null
)

data class CategoryDataItemEntity(
    val image: String? = null,
    val createdAt: String? = null,
    val name: String? = null,
    val id: String? = null,
    val slug: String? = null,
    val updatedAt: String? = null
)

data class CategoryMetadataEntity(
    val numberOfPages: Int? = null,
    val limit: Int? = null,
    val currentPage: Int? = null
)

