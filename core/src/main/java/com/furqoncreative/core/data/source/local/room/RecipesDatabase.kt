package com.furqoncreative.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.furqoncreative.core.data.source.local.entity.recipe.RecipeEntity
import com.furqoncreative.core.data.source.local.entity.recipes.RecipesEntity
import com.furqoncreative.core.data.source.local.entity.recipesbycategory.RecipesByCategoryEntity
import com.furqoncreative.core.data.source.local.entity.recipescategory.RecipesCategoryEntity
import com.furqoncreative.core.data.source.local.entity.recipesbysearch.RecipesBySearchEntity

@Database(
    entities = [RecipesEntity::class, RecipeEntity::class, RecipesByCategoryEntity::class, RecipesCategoryEntity::class, RecipesBySearchEntity::class], version = 3, exportSchema = false
)
//@TypeConverters(Converters::class)
abstract class RecipesDatabase : RoomDatabase() {

    abstract fun recipesByCategoryDao(): RecipesByCategoryDao

    abstract fun recipesDao(): RecipesDao

    abstract fun recipesCategoryDao(): RecipesCategoryDao

    abstract fun recipesBySearchDao(): RecipesBySearchDao

    abstract fun recipeDao(): RecipeDao

}