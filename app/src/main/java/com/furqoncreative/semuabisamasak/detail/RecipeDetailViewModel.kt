package com.furqoncreative.semuabisamasak.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.usecase.recipe.RecipeUseCase
import com.furqoncreative.core.domain.usecase.recipes.RecipesUseCase


class RecipeDetailViewModel(recipeUseCase: RecipeUseCase, recipesUseCase: RecipesUseCase) :
    ViewModel() {
    val recipe: (String) -> LiveData<Resource<Recipe>> = {
        recipeUseCase.getRecipe(it).asLiveData()
    }

}
