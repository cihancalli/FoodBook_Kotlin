package com.zerdasoftware.foodbook.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.zerdasoftware.foodbook.model.RecipeModel

@Dao
interface RecipeDAO {

    @Query("SELECT * FROM recipemodel")
    fun getAll(): List<RecipeModel>

    @Query("SELECT * FROM recipemodel WHERE id = :id")
    fun findById(id: Int): RecipeModel

    @Insert
    fun insert(recipe: RecipeModel)

    @Delete
    fun delete(recipe: RecipeModel)
}