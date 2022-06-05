package com.moviles.proyectofinaltienda

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moviles.proyectofinaltienda.databinding.ItemWishlistBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val articles: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding= ItemWishlistBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, positionsa: Int) {
        holder.render(articles[positionsa] as JSONObject)

    }

    override fun getItemCount(): Int = articles.length()



    class MainHolder(val binding: ItemWishlistBinding) : RecyclerView.ViewHolder(binding.root){
        fun render (poke: JSONObject){



        }
    }
}