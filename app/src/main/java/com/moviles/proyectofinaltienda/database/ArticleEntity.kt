package com.moviles.proyectofinaltienda.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = TABLE_ARTICLES)
data class ArticleEntity(
    @ColumnInfo(name = "article_id") @PrimaryKey val artid: String,
    //@ColumnInfo(name = "descri") val description: String,
    val description: String,
    val price: String,
    val stars: String

   )


fun ArticleEntity.toArticle()= Article(
    artid,
    description,
    price,
    stars


)