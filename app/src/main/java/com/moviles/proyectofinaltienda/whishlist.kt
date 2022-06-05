package com.moviles.proyectofinaltienda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.databinding.FragmentHome1Binding
import com.moviles.proyectofinaltienda.databinding.FragmentWhishlistBinding
import com.moviles.proyectofinaltienda.databinding.ItemWishlistBinding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class whishlist : Fragment() {


    private lateinit var binding: ItemWishlistBinding
    private lateinit var  queue: RequestQueue
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ItemWishlistBinding.inflate(inflater,container,false)

        queue = Volley.newRequestQueue(context)
        for(i in 1..5) {
            getArticle()
        }
        binding.btnCarrito.setOnClickListener { response ->
            mainViewModel.saveArticle(
                Article(article_id = binding.tvTittle.text.toString(),description =
            binding.tvDescription.text.toString(),price = binding.tvPrecio.text.toString(),stars =
            binding.tvStars.text.toString())
            )
            mainViewModel.getArticles()
        }

        return binding.root
    }

    fun  getArticle(){


    var random=(1..20).random()
        val url = "https://fakestoreapi.com/products/${random
        }"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response->
            binding.tvTittle.setText(response.getString("title"))
            binding.tvDescription.setText(response.getString("description"))
            binding.tvPrecio.setText(response.getString("price"))
            binding.tvStars.setText(response.getJSONObject("rating").getString("rate"))
            val img =response.getString("image")
            Picasso.get().load(img).into(binding.ivArticle)
            binding.tvMoneda.isVisible=true
            binding.btnCarrito.isVisible=true
            binding.tvCalif.isVisible=true
        },
            Response.ErrorListener { errorMessage ->


            })
        queue.add(jsonRequest)
    }
    override fun onStop() {
        super.onStop()
        queue.cancelAll("stopped")
    }
}
