package com.route.e_commerce_c40_gsat.Screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.entity.ApiResult
import com.route.domain.entity.category.CategoryDataItemEntity
import com.route.domain.usecases.categories.GetCategoriesUseCase
import com.route.e_commerce_c40_gsat.BottomAppBarTabs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel(), HomeContract.ViewModel {
    val categoriesStateList = mutableStateListOf<CategoryDataItemEntity>()
    val showLoading = mutableStateOf(true)
    val errorState = mutableStateOf("")
    val showMessage = mutableStateOf(false)

    override fun invokeActions(homeAction: HomeContract.HomeAction) {
        when (homeAction) {
            HomeContract.HomeAction.ClickedOnCart -> {}
            is HomeContract.HomeAction.ClickedOnCategory -> {

            }

            HomeContract.HomeAction.ViewAllCategories -> {}
        }
    }

    private val _states = mutableStateOf<HomeContract.HomeStates>(HomeContract.HomeStates.Idle)
    private val _events = mutableStateOf<HomeContract.HomeEvents>(HomeContract.HomeEvents.Idle)

    // Mutable State
    // Immutable ->
    override val states: State<HomeContract.HomeStates>
        get() = _states
    override val events: State<HomeContract.HomeEvents>
        get() = _events

    fun getCategories() {
        viewModelScope.launch {
            val response = getCategoriesUseCase()
            response.collect { result ->
                when (result) {
                    is ApiResult.Error -> {
                        _states.value = HomeContract.HomeStates.Error(result.message)
                    }

                    is ApiResult.Loading -> {
                        _states.value = HomeContract.HomeStates.Loading
                    }

                    is ApiResult.Success -> {
                        _states.value = HomeContract.HomeStates.Success(result.data)
                    }
                }
            }
        }
    }


}