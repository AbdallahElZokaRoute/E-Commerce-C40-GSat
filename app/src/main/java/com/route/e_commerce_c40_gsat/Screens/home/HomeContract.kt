package com.route.e_commerce_c40_gsat.Screens.home

import androidx.compose.runtime.State
import com.route.domain.entity.category.CategoryDataItemEntity

interface HomeContract {
    interface ViewModel {
        fun invokeActions(homeAction: HomeAction)
        val states: State<HomeStates>
        val events: State<HomeEvents>
    }

    sealed interface HomeAction {
        data object ViewAllCategories : HomeAction
        data class ClickedOnCategory(val categoryId: String) : HomeAction
        data object ClickedOnCart : HomeAction
    }

    sealed interface HomeStates {
        data object Idle : HomeStates
        data object Loading : HomeStates
        data class Error(val message: String) : HomeStates
        data class Success(val categories: List<CategoryDataItemEntity>) : HomeStates
    }

    sealed interface HomeEvents {
        data object Idle : HomeEvents
        data class NavigateToCategoryById(val categoryId: String) : HomeEvents
    }

}