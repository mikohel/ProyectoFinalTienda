package com.moviles.proyectofinaltienda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.moviles.proyectofinaltienda.databinding.FragmentHome1Binding
import com.moviles.proyectofinaltienda.databinding.FragmentProfileBinding
import org.json.JSONObject


class profile : Fragment() {
    private lateinit var  binding: FragmentProfileBinding
    private lateinit var  queue: RequestQueue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentProfileBinding.inflate(inflater,container,false)
        queue = Volley.newRequestQueue(context)
        val database = Firebase.database
        val myRef = database.reference

        binding.btnswitch.setOnClickListener { response ->
            if(binding.etswitchU.text.toString() != ""){
                val user = binding.etswitchU.text.toString()
                myRef.child("usuarios").child("${user}").get().addOnSuccessListener { record ->
                    val jsonOb = JSONObject(record.value.toString())
                    binding.tvNombre.setText(jsonOb.getString("nombre").toString())
                    binding.tvLevel.setText(jsonOb.getString("level").toString())
                    binding.tvUsername.setText(jsonOb.getString("user_name").toString())
                    binding.tvProductos.setText(jsonOb.getString("wish_list").toString())

            }
        }

    }
   return binding.root
    }

}

