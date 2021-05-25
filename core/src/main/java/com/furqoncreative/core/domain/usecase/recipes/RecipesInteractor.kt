package com.furqoncreative.core.domain.usecase.recipes

import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipes.Recipes
import com.furqoncreative.core.domain.repository.recipes.IRecipesRepository
import kotlinx.coroutines.flow.Flow

class RecipesInteractor(private val repository: IRecipesRepository) : RecipesUseCase {

    override fun getAllRecipes() = repository.getAllRecipes()

    override fun getFavoriteRecipes() = repository.getFavoriteRecipes()

    override fun setFavoriteRecipes(recipes: Recipes, state: Boolean) =
        repository.setFavoriteRecipes(recipes, state)
}