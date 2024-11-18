package com.zerdasoftware.foodbook.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zerdasoftware.foodbook.model.RecipeModel


@Database(entities = [RecipeModel::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDAO(): RecipeDAO
}