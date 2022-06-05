package com.moviles.proyectofinaltienda

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.databinding.ItemHome1Binding
import com.moviles.proyectofinaltienda.databinding.ItemWishlistBinding
import org.json.JSONArray
import org.json.JSONObject

class Home1Adapter (private val articles:  List<Article>): RecyclerView.Adapter<Home1Adapter.Home1Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Home1Adapter.Home1Holder {
        val binding= ItemHome1Binding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Home1Holder(binding)
    }

    override fun onBindViewHolder(holder: Home1Adapter.Home1Holder, position: Int) {
        holder.render(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class Home1Holder(val binding: ItemHome1Binding) : RecyclerView.ViewHolder(binding.root){
        fun render (article : Article){
            binding.tvTittle.setText(article.article_id)
        }



        }
    }




