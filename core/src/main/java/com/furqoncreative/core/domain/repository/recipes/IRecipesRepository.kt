package com.furqoncreative.core.domain.repository.recipes

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipes.Recipes
import kotlinx.coroutines.flow.Flow

interface IRecipesRepository {

    fun getAllRecipes(): Flow<Resource<List<Recipes>>>

    fun getFavoriteRecipes(): Flow<List<Recipes>>

    fun setFavoriteRecipes(recipes: Recipes, state: Boolean)

}