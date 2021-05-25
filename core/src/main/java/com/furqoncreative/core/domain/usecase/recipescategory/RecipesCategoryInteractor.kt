package com.furqoncreative.core.domain.usecase.recipescategory

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import com.furqoncreative.core.domain.model.recipescategory.RecipesCategory
import com.furqoncreative.core.domain.repository.recipesbycategory.IRecipesByCategoryRepository
import com.furqoncreative.core.domain.repository.recipescategory.IRecipesCategoryRepository
import kotlinx.coroutines.flow.Flow

class RecipesCategoryInteractor(private val repository: IRecipesCategoryRepository) :
    RecipesCategoryUseCase {

    override fun getRecipesCategory(): Flow<Resource<List<RecipesCategory>>> =
        repository.getAllRecipesCategory()

}