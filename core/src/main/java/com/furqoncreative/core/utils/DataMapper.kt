package com.furqoncreative.core.utils

import com.furqoncreative.core.data.source.local.entity.recipe.RecipeEntity
import com.furqoncreative.core.data.source.local.entity.recipes.RecipesEntity
import com.furqoncreative.core.data.source.local.entity.recipesbycategory.RecipesByCategoryEntity
import com.furqoncreative.core.data.source.local.entity.recipesbysearch.RecipesBySearchEntity
import com.furqoncreative.core.data.source.local.entity.recipescategory.RecipesCategoryEntity
import com.furqoncreative.core.data.source.remote.response.recipedetail.RecipeDetail
import com.furqoncreative.core.data.source.remote.response.recipesbycategory.RecipesByCategoryItem
import com.furqoncreative.core.data.source.remote.response.recipesbysearch.RecipesBySearchItem
import com.furqoncreative.core.data.source.remote.response.recipescategory.RecipesCategoryItem
import com.furqoncreative.core.data.source.remote.response.recipeslist.RecipesListItem
import com.furqoncreative.core.domain.model.recipe.Recipe
import com.furqoncreative.core.domain.model.recipes.Recipes
import com.furqoncreative.core.domain.model.recipesbycategory.RecipesByCategory
import com.furqoncreative.core.domain.model.recipesbysearch.RecipesBySearch
import com.furqoncreative.core.domain.model.recipescategory.RecipesCategory


object DataMapper {
    fun mapRecipesResponsesToEntities(input: List<RecipesListItem>): List<RecipesEntity> {
        val recipesList = ArrayList<RecipesEntity>()
        input.map {
            val recipes = it.key?.let { it1 ->
                RecipesEntity(
                    times = it.times,
                    thumb = it.thumb,
                    portion = it.portion,
                    title = it.title,
                    key = it1,
                    dificulty = it.dificulty,
                    isFavorite = false
                )
            }
            recipes?.let { it1 -> recipesList.add(it1) }
        }
        return recipesList
    }

    fun mapRecipesEntityToDomain(input: List<RecipesEntity>): List<Recipes> =
        input.map {
            Recipes(
                times = it.times,
                thumb = it.thumb,
                portion = it.portion,
                title = it.title,
                key = it.key,
                dificulty = it.dificulty,
                isFavorite = false
            )
        }

    fun mapRecipesDomainToEntity(input: Recipes) = input.key?.let {
        RecipesEntity(
            times = input.times,
            thumb = input.thumb,
            portion = input.portion,
            title = input.title,
            key = it,
            dificulty = input.dificulty,
            isFavorite = false
        )
    }

    fun mapRecipesCategoryResponsesToEntities(input: List<RecipesCategoryItem>): List<RecipesCategoryEntity> {
        val recipesCategoryList = ArrayList<RecipesCategoryEntity>()
        input.map {
            val recipesCategory = it.key?.let { it1 ->
                RecipesCategoryEntity(key = it.key, category = it.category, url = it.url)
            }
            recipesCategory?.let { it1 -> recipesCategoryList.add(it1) }
        }
        return recipesCategoryList
    }

    fun mapRecipesCategoryEntityToDomain(input: List<RecipesCategoryEntity>): List<RecipesCategory> =
        input.map {
            RecipesCategory(key = it.key, category = it.category, url = it.url)
        }


    fun mapRecipesByCategoryResponsesToEntities(param:String, input: List<RecipesByCategoryItem>): List<RecipesByCategoryEntity> {
        val recipesList = ArrayList<RecipesByCategoryEntity>()
        input.map {
            val recipes = it.key?.let { it1 ->
                RecipesByCategoryEntity(
                    times = it.times,
                    thumb = it.thumb,
                    portion = it.portion,
                    title = it.title,
                    key = it1,
                    dificulty = it.dificulty,
                    category = param
                )
            }
            recipes?.let { it1 -> recipesList.add(it1) }
        }
        return recipesList
    }

    fun mapRecipesByCategoryEntityToDomain(input: List<RecipesByCategoryEntity>): List<RecipesByCategory> =
        input.map {
            RecipesByCategory(
                times = it.times,
                thumb = it.thumb,
                portion = it.portion,
                title = it.title,
                key = it.key,
                dificulty = it.dificulty
            )
        }

    fun mapRecipesBySearchResponsesToEntities(input: List<RecipesBySearchItem>): List<RecipesBySearchEntity> {
        val recipesList = ArrayList<RecipesBySearchEntity>()
        input.map {
            val recipes = it.key?.let { it1 ->
                RecipesBySearchEntity(
                    times = it.times,
                    thumb = it.thumb,
                    portion = it.serving,
                    title = it.title,
                    key = it1,
                    dificulty = it.difficulty
                )
            }
            recipes?.let { it1 -> recipesList.add(it1) }
        }
        return recipesList
    }

    fun mapRecipesBySearchEntityToDomain(input: List<RecipesBySearchEntity>): List<RecipesBySearch> =
        input.map {
            RecipesBySearch(
                times = it.times,
                thumb = it.thumb,
                portion = it.portion,
                title = it.title,
                key = it.key,
                dificulty = it.dificulty
            )
        }

    fun mapRecipeResponsesToEntities(param: String, input: RecipeDetail): RecipeEntity {
        val recipe = RecipeEntity(
            times = input.times,
            thumb = input.thumb,
            servings = input.servings,
            title = input.title,
            dificulty = input.dificulty,
            ingredient = input.ingredient?.joinToString(),
            step = input.step?.joinToString(),
            desc = input.desc,
            key = param
        )
        return recipe
    }

    fun mapRecipeEntityToDomain(param: RecipeEntity?): Recipe {
        var recipe = Recipe()
        if (param != null) {
            recipe = Recipe(
                times = param.times,
                thumb = param.thumb,
                servings = param.servings,
                title = param.title,
                dificulty = param.dificulty,
                ingredient = param.ingredient?.split(","),
                step = param.step?.split(","),
                desc = param.desc
            )
        }

        return recipe
    }
}