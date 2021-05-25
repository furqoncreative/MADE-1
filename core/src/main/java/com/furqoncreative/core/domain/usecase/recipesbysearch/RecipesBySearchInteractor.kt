package com.furqoncreative.core.domain.usecase.recipesbysearch

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipesbysearch.RecipesBySearch
import com.furqoncreative.core.domain.repository.recipesbycategory.IRecipesByCategoryRepository
import com.furqoncreative.core.domain.repository.recipesbysearch.IRecipesBySearchRepository
import kotlinx.coroutines.flow.Flow

class RecipesBySearchInteractor(private val repository: IRecipesBySearchRepository) :
    RecipesBySearchUseCase {

    override fun getRecipesBySearch(param: String): Flow<Resource<List<RecipesBySearch>>> =
        repository.getAllRecipesBySearch(param)

}