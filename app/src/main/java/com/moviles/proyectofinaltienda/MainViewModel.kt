package com.moviles.proyectofinaltienda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.database.DatabaseManager
import com.moviles.proyectofinaltienda.database.MyCoroutines
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    fun saveArticle(article: Article){
        viewModelScope.launch {
            val articleDao = DatabaseManager.instance.database.articleDao()
            MyCoroutines(articleDao).save(article)
        }
    }

    fun deleteArticle(article: Article){
        viewModelScope.launch {
            val articleDao = DatabaseManager.instance.database.articleDao()
            MyCoroutines(articleDao).delete(article)
        }
    }

    val savedArticles= MutableLiveData<List<Article>>()

    fun  getArticles(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.articleDao()
            savedArticles.value = MyCoroutines(userDao).getArticles().value
        }
    }
}