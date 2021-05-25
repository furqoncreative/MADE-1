package com.furqoncreative.core.domain.usecase.recipe

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeUseCase {
    fun getRecipe(param: String): Flow<Resource<Recipe>>
}