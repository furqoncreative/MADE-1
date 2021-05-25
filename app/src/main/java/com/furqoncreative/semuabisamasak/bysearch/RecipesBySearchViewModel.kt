package com.furqoncreative.semuabisamasak.bysearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.data.Resource
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import com.furqoncreative.core.domain.model.recipesbysearch.RecipesBySearch
import com.furqoncreative.core.domain.usecase.recipe.RecipeUseCase
import com.furqoncreative.core.domain.usecase.recipes.RecipesUseCase
import com.furqoncreative.core.domain.usecase.recipesbysearch.RecipesBySearchUseCase


class RecipesBySearchViewModel(recipesBySearchUseCase: RecipesBySearchUseCase) :
    ViewModel() {
    val recipes: (String) -> LiveData<Resource<List<RecipesBySearch>>> = {
        recipesBySearchUseCase.getRecipesBySearch(it).asLiveData()
    }
}
