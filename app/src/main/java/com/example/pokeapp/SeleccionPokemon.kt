package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.ModelsDefintition.Pokemon
import kotlinx.android.synthetic.main.activity_seleccion__pokemon.*
import tech.twentytwobits.recyclerviewexample.ClickListener
import tech.twentytwobits.recyclerviewexample.LongClickListener

class SeleccionPokemon : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion__pokemon)

        layoutManager = GridLayoutManager(this, 3)

        val pokemons = ArrayList<Pokemon>()
       // pokemons.add(Pokemon("Bulbasaur", ""))


        val adapter = AdapterCustom(this, pokemons, object : ClickListener {
            override fun onClick(view: View, index: Int) {
                Toast.makeText(applicationContext, pokemons[index].name, Toast.LENGTH_SHORT).show()
            }
        }, object : LongClickListener {
            override fun LongClickListener(view: View, index: Int) {
                Log.d("LONGCLICK", pokemons[index].name)
            }
        })

        recycleViewPokemon.setHasFixedSize(true)
        recycleViewPokemon.layoutManager = layoutManager
        recycleViewPokemon.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener {
            Log.d("REFRESH", "La información se ha refrescado")

            // Mentirita
            for (i in 1..100000000) {

            }
            swipeRefreshLayout.isRefreshing = false

        }
    }

}
