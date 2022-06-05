package com.moviles.proyectofinaltienda.database

import androidx.room.*

@Dao
interface ArticleDao {

    @Query("SELECT * FROM $TABLE_ARTICLES")
    fun getUsersFromDatabase(): List<ArticleEntity>

    @Query("SELECT*FROM $TABLE_ARTICLES WHERE article_id = :artid")
    fun getUserByUuid(artid: String): ArticleEntity

    @Delete
    fun delete(article: ArticleEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(article:ArticleEntity)

}