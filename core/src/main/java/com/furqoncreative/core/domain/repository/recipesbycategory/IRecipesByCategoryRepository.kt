package com.furqoncreative.core.domain.repository.recipesbycategory

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import com.furqoncreative.core.domain.model.recipesbysearch.RecipesBySearch
import kotlinx.coroutines.flow.Flow

interface IRecipesByCategoryRepository {

    fun getAllRecipesByCategory(param: String): Flow<Resource<List<RecipesByCategory>>>

}