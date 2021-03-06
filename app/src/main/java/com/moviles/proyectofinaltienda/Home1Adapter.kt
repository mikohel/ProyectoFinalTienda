package com.moviles.proyectofinaltienda

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.databinding.ItemHome1Binding
import com.moviles.proyectofinaltienda.databinding.ItemWishlistBinding
import org.json.JSONArray
import org.json.JSONObject
private lateinit var database: DatabaseReference
class Home1Adapter (private val articles:  List<Article>, private val viewhome: MainViewModel): RecyclerView.Adapter<Home1Adapter.Home1Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home1Adapter.Home1Holder {
        val binding= ItemHome1Binding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Home1Holder(binding,viewhome)
    }

    override fun onBindViewHolder(holder: Home1Adapter.Home1Holder, position: Int) {
        holder.render(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class Home1Holder(val binding: ItemHome1Binding, val viewhome: MainViewModel) : RecyclerView.ViewHolder(binding.root){
        fun render (article : Article){
            val myDB = FirebaseDatabase.getInstance()
            database = myDB.reference
            binding.tvTittle.setText(article.article_id)
            binding.tvDescription.setText(article.description)
            binding.tvPrecio.setText(article.price)
            binding.tvStars.setText(article.stars)
            binding.tvCalif.isVisible=true
            binding.btnDelete.setOnClickListener {
                viewhome.deleteArticle(article)
                viewhome.getArticles()
            }

        }



        }
    }




