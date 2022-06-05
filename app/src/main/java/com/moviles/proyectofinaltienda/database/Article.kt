package com.moviles.proyectofinaltienda.database


class Article(
    article_id: String,
    description: String,
    price: String,
    stars: String,

    /* user_name: String,
     user_altura: Double,
     user_peso: Double,
     user_email: String,
     user_password: String
 */
) {
    val article_id: String = article_id
    val description: String = description
    val price: String = price
    val stars: String = stars
    /*  val user_name: String = user_name
    val user_altura: Double = user_altura
    val user_peso: Double = user_peso
    val user_email: String = user_email
    val user_password:String = user_password
  */
}

fun Article.toEntity()= ArticleEntity(
    article_id,
    description,
    price,
    stars
    /*  user_name,
      user_altura,
      user_peso,
      user_email,
      user_password
  */)