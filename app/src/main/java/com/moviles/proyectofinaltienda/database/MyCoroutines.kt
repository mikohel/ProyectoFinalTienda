package com.moviles.proyectofinaltienda.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val articleDao: ArticleDao) {

    suspend fun save(article:Article)= withContext(Dispatchers.IO){
        articleDao.save(article.toEntity())
    }


    suspend fun delete(article: Article) = withContext(Dispatchers.IO){
        articleDao.delete((article.toEntity()))
    }

    suspend fun getArticles(): LiveData<List<Article>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(articleDao.getUsersFromDatabase().map { eachArticleEntity ->
            eachArticleEntity.toArticle() })
    }
}