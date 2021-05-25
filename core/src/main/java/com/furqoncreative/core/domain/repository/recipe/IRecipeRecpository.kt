package com.furqoncreative.core.domain.repository.recipe

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import kotlinx.coroutines.flow.Flow


interface IRecipeRecpository {

    fun getRecipe(param: String): Flow<Resource<Recipe>>
}