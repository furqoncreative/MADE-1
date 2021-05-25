package com.furqoncreative.core.data.source.local.room

import androidx.room.*
import com.furqoncreative.core.data.source.local.entity.recipe.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe WHERE `key` = :param")
    fun getRecipe(param:String): Flow<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipes: RecipeEntity)

//    @Transaction
//    suspend fun insertRecipe(recipes: RecipeEntity) {
//        insert(recipes)
//    }
}
