package com.route.e_commerce_c40_gsat.Screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.usecases.categories.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {
    val categoriesStateList = mutableStateListOf<CategoryDataItemEntity>()
    fun getCategories() {
        viewModelScope.launch {
            val categories = getCategoriesUseCase()
            categoriesStateList.addAll(categories)
        }
    }
}