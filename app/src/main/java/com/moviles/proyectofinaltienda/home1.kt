package com.moviles.proyectofinaltienda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.moviles.proyectofinaltienda.database.Article
import com.moviles.proyectofinaltienda.databinding.ActivityMainBinding
import com.moviles.proyectofinaltienda.databinding.FragmentHome1Binding
import com.squareup.picasso.Picasso
import org.json.JSONObject

class home1 : Fragment() {
    private lateinit var binding: FragmentHome1Binding
    private lateinit var  queue: RequestQueue
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHome1Binding.inflate(inflater,container,false)
        queue = Volley.newRequestQueue(context)

        binding.btnBuca.setOnClickListener { response ->
            if(binding.etBusca.text.toString() != ""){
            var article = binding.etBusca.text.toString().lowercase()
            getArticle(article)

            }
        }


        binding.btnCarrito.setOnClickListener { response ->
            mainViewModel.saveArticle(Article(article_id = binding.tvTittle.text.toString()))
            mainViewModel.getArticles()
        }


        mainViewModel.getArticles()
        mainViewModel.savedArticles.observe(this){articleList ->
            if (!articleList.isNullOrEmpty()){
                for (user in articleList){
                    Log.d("thesearetheusers", user.article_id)
                    binding.rvWishList.adapter = Home1Adapter(articleList)
                }

            }
            else{
                Log.d("thesearetheusers","null or empty")
            }

        }


        return binding.root
    }

    fun  getArticle(article: String){

        val url = "https://fakestoreapi.com/products/${article}"
        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response->
            binding.etBusca.text.clear()
            binding.tvTittle.setText(response.getString("title"))
            binding.tvDescription.setText(response.getString("description"))
            binding.tvPrecio.setText(response.getString("price"))
            binding.tvStars.setText(response.getJSONObject("rating").getString("rate"))
            val img =response.getString("image")
            Picasso.get().load(img).into(binding.ivArticle)
            binding.tvMoneda.isVisible=true
            binding.tvCalif.isVisible=true
        },

            Response.ErrorListener { errorMessage ->
                binding.etBusca.text.clear()

            })
        queue.add(jsonRequest)
    }
    override fun onStop() {
        super.onStop()
        queue.cancelAll("stopped")
    }

}
