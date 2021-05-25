package com.furqoncreative.core.domain.usecase.recipescategory

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import com.furqoncreative.core.domain.model.recipescategory.RecipesCategory
import kotlinx.coroutines.flow.Flow

interface RecipesCategoryUseCase {
    fun getRecipesCategory(): Flow<Resource<List<RecipesCategory>>>
}