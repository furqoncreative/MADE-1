package com.furqoncreative.core.domain.usecase.recipe

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.repository.recipe.IRecipeRecpository
import kotlinx.coroutines.flow.Flow

class RecipeInteractor(private val repository: IRecipeRecpository) : RecipeUseCase {

    override fun getRecipe(param: String): Flow<Resource<Recipe>> = repository.getRecipe(param)
}