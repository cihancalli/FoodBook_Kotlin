package com.zerdasoftware.foodbook.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.zerdasoftware.foodbook.model.RecipeModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface RecipeDAO {

    @Query("SELECT * FROM recipemodel")
    fun getAll(): Flowable<List<RecipeModel>>

    @Query("SELECT * FROM recipemodel WHERE id = :id")
    fun findById(id: Int): Flowable<RecipeModel>

    @Insert
    fun insert(recipe: RecipeModel) : Completable

    @Delete
    fun delete(recipe: RecipeModel): Completable
}