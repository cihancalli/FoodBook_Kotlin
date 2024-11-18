package com.zerdasoftware.foodbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class RecipeModel (
    @ColumnInfo("name")
    var name:String,

    @ColumnInfo("ingredients")
    var ingredients:String,

    @ColumnInfo("image")
    var image:ByteArray
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}