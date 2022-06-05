package com.moviles.proyectofinaltienda.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = TABLE_ARTICLES)
data class ArticleEntity(
    @ColumnInfo(name = "article_id") @PrimaryKey val artid: String,
    /* @ColumnInfo(name = "user_name") val name: String,
     val user_altura: Double,
     val user_peso: Double,
     val user_email: String,
     val user_password:String

   */)


fun ArticleEntity.toArticle()= Article(
    artid

)