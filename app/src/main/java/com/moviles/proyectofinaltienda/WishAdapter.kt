package com.moviles.proyectofinaltienda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.databinding.ItemHome1Binding
import com.moviles.proyectofinaltienda.databinding.ItemWishlistBinding
private lateinit var database: DatabaseReference
class WishAdapter(private val articles:  List<Article>, private val viewhome: MainViewModel): RecyclerView.Adapter<WishAdapter.WishHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishAdapter.WishHolder {
        val binding= ItemWishlistBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return WishHolder(binding,viewhome)
    }

    override fun onBindViewHolder(holder: WishAdapter.WishHolder, position: Int) {
        holder.render(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class WishHolder(val binding: ItemWishlistBinding, val viewhome: MainViewModel) : RecyclerView.ViewHolder(binding.root){
        fun render (article : Article){
            val myDB = FirebaseDatabase.getInstance()
            database = myDB.reference
            binding.tvTittle.setText(article.article_id)
            binding.tvDescription.setText(article.description)
            binding.tvPrecio.setText(article.price)
            binding.tvStars.setText(article.stars)

        }



    }
}
