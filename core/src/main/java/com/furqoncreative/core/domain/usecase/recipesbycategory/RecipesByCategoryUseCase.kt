package com.furqoncreative.core.domain.usecase.recipesbycategory

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import kotlinx.coroutines.flow.Flow

interface RecipesByCategoryUseCase {
    fun getRecipesByCategory(param: String): Flow<Resource<List<RecipesByCategory>>>
}